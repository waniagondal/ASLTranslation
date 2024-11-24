package frameworks_and_drivers.Speech2Text;

import interface_adapter.Speech2Text.AudioRecorder;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * A class that implements the {@link AudioRecorder} interface to record audio using the system's microphone.
 * It captures audio data and provides it in byte array format for further processing.
 */
public class MicrophoneAudioRecorder implements AudioRecorder {
    private TargetDataLine targetDataLine;
    private AudioFormat audioFormat;
    private ByteArrayOutputStream out;
    private Thread captureThread;
    private boolean isRecording;

    @Override
    public void start() {
        if (isRecording) {
            return;
        }
        isRecording = true;

        audioFormat = getAudioFormat();
        DataLine.Info info = new DataLine.Info(
                TargetDataLine.class, audioFormat);

        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            return;
        }

        try {
            targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            out = new ByteArrayOutputStream();
            captureThread = new Thread(() -> {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while (isRecording && !Thread.currentThread().isInterrupted()) {
                    bytesRead = targetDataLine.read(buffer, 0,
                            buffer.length);
                    out.write(buffer, 0, bytesRead);
                }


                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            captureThread.start();
            System.out.println("Recording started...");
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * Stops the audio recording process. If the recorder is not recording, this method does nothing.
     */
    @Override
    public void stop() {
        if (!isRecording) {
            return;
        }
        isRecording = false;

        if (captureThread != null && captureThread.isAlive()) {
            captureThread.interrupt();
            try {
                captureThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (targetDataLine != null) {
            targetDataLine.stop();
            targetDataLine.close();
        }
        System.out.println("Recording stopped.");
    }

    @Override
    public byte[] getAudioData() {
        return out != null ? out.toByteArray() : new byte[0];
    }
    /**
     * Configures and returns the audio format to be used for recording.
     *
     * @return The {@link AudioFormat} for the recording.
     */
    private AudioFormat getAudioFormat() {
        float sampleRate = 16000F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
    }
}
