package use_case.text2speech;

import javax.sound.sampled.AudioInputStream;

/**
 * Output data for the Text to Speech Use Case.
 */
public class Text2SpeechOutputData {
    private final AudioInputStream audioStream;

    public Text2SpeechOutputData(AudioInputStream audioStream) {
        this.audioStream = audioStream;
    }

    public AudioInputStream getAudioContents() {
        return audioStream;
    }
}
