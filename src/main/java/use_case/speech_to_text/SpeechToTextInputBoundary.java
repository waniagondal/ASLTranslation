package use_case.speech_to_text;

/**
 * Input boundary for processing speech-to-text.
 * This interface is implemented by the use case that converts audio data into text
 */

public interface SpeechToTextInputBoundary {

    /**
     * Process the given speech input and returns the transcribed text.
     *
     * @param inputData the audio data to process.
     * @throws Exception if processing fails.
     */
    void processSpeech(SpeechToTextInputData inputData) throws Exception;
}
