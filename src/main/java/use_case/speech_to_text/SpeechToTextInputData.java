package use_case.speech_to_text;

/**
 * Represents the raw input audio data used for transcription.
 * This class encapsulates the audio data that will be processed and transcribed into text.
 */
public class SpeechToTextInputData {
    private final byte[] audioData;

    /**
     * Constructs a new SpeechToTextInputData instance with the given audio data.
     *
     * @param audioData The raw audio data to be transcribed.
     */
    public SpeechToTextInputData(byte[] audioData) {
        this.audioData = audioData;
    }

    /**
     * Returns the raw audio data.
     *
     * @return The byte array representing the audio data.
     */
    public byte[] getAudioData() {
        return audioData;
    }
}
