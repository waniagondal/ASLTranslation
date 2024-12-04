package frameworks_and_drivers.speech_to_text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import interface_adapter.speech_to_text.AudioRecorderInterface;

/**
 * A concrete implementation of the AudioRecorder interface that records audio via the system's microphone.
 */
public class MicrophoneAudioRecorder implements AudioRecorderInterface {

    private static final int BUFFER_SIZE = 4096;

    private TargetDataLine targetDataLine;
    private AudioFormat audioFormat;
    private ByteArrayOutputStream out;
    private Thread captureThread;
    private boolean isRecording;

    /**
     * Starts the audio recording process.
     */
    @Override
    public void start() {
        // If already recording, do nothing
        if (!isRecording) {
            isRecording = true;

            audioFormat = getAudioFormat();
            final DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

            // Check if the system supports the audio format
            if (AudioSystem.isLineSupported(info)) {
                try {
                    // Set up the TargetDataLine for recording
                    targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
                    targetDataLine.open(audioFormat);
                    targetDataLine.start();

                    // Prepare to capture the audio data in the background
                    out = new ByteArrayOutputStream();
                    captureThread = new Thread(this::captureAudioData);
                    captureThread.start();
                    System.out.println("Recording started...");
                }
                catch (LineUnavailableException error) {
                    error.printStackTrace();
                }
            }
            else {
                System.out.println("Line not supported");
            }
        }
    }

    /**
     * Stops the audio recording process.
     */
    @Override
    public void stop() {
        // Check if the recording is active
        if (isRecording) {
            isRecording = false;

            // Interrupt the capture thread if it's running
            if (captureThread != null && captureThread.isAlive()) {
                captureThread.interrupt();
                try {
                    captureThread.join();
                }
                catch (InterruptedException error) {
                    error.printStackTrace();
                }
            }
            // Stop and close the target data line to release resources
            if (targetDataLine != null) {
                targetDataLine.stop();
                targetDataLine.close();
            }

            // Output the message indicating the recording has stopped
            System.out.println("Recording stopped.");
        }
    }

    /**
     * Retrieves the recorded audio data.
     *
     * @return A byte array containing the recorded audio data.
     */
    @Override
    public byte[] getAudioData() {
        byte[] byteArray = new byte[0];
        if (out != null) {
            byteArray = out.toByteArray();
        }
        return byteArray;
    }

    /**
     * Configures and returns the audio format to be used for recording.
     *
     * @return The AudioFormat for the recording.
     */
    private AudioFormat getAudioFormat() {
        final float sampleRate = 16000F;
        final int sampleSizeInBits = 16;
        final int channels = 1;
        final boolean signed = true;
        final boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    }

    /**
     * Method to capture the audio data in the background thread.
     */
    private void captureAudioData() {
        final byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        // Capture audio data in a loop while recording
        while (isRecording && !Thread.currentThread().isInterrupted()) {
            bytesRead = targetDataLine.read(buffer, 0, buffer.length);
            out.write(buffer, 0, bytesRead);
        }

        try {
            out.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }
}
