package frameworks_and_drivers.text_to_speech;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.google.protobuf.ByteString;

/**
 * Handles audio playback from a ByteString containing the audio data.
 */
public class AudioPlayer {

    /**
     * Plays the audio from the given ByteString content.
     *
     * @param audioContents the audio data to be played
     * @throws LineUnavailableException if the audio line is unavailable
     * @throws IOException if there is an error in the audio stream
     */
    public void playAudio(ByteString audioContents) throws LineUnavailableException, IOException {
        // Convert ByteString to AudioInputStream
        AudioInputStream audioStream = new AudioInputStream(
                new ByteArrayInputStream(audioContents.toByteArray()),
                new AudioFormat(16000, 16, 1, true, false),
                audioContents.size());

        // Get the system's default clip to play the audio
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream); // Open the audio stream
        clip.start();  // Start playback
    }
}
