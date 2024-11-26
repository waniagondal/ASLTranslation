package entity;
/**
 * Represents the transcription of audio input.
 * This entity holds the text result of processing audio data through a speech-to-text system.
 */
public class AudioTranscription {
    /**
     * The transcribed text from the audio input.
     */
    private final String text;

    /**
     * Constructor to create an AudioTranscription object with the given transcribed text.
     *
     * @param text The transcribed text of the audio input.
     */
    public AudioTranscription(String text) {
        this.text = text;
    }

    /**
     * Returns the transcribed text.
     *
     * @return The text result of the audio transcription.
     */
    public String getText() {
        return text;
    }
}
