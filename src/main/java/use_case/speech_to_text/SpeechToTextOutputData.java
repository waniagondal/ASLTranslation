package use_case.speech_to_text;

/**
 * Represents the output data of the speech-to-text use case, which contains the transcribed text.
 * This class encapsulates the result of the transcription process.
 */
public class SpeechToTextOutputData {
    private final String transcription;

    /**
     * Constructs a new SpeechToTextOutputData instance with the given transcription text.
     *
     * @param transcription The transcribed text.
     */
    public SpeechToTextOutputData(String transcription) {
        this.transcription = transcription;
    }

    /**
     * Returns the transcribed text.
     *
     * @return The transcription of the audio.
     */
    public String getTranscription() {
        return transcription;
    }
}
