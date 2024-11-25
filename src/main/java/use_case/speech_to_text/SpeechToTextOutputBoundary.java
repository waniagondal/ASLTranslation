package use_case.speech_to_text;

/**
 * Defines the output boundary for delivering the processed transcription result.
 */
public interface SpeechToTextOutputBoundary {

    /**
     * Delivers the processed transcription.
     *
     * @param outputData the transcription result to deliver.
     */
    void deliverTranscription(SpeechToTextOutputData outputData);
}