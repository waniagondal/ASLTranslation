package interface_adapter.speech_to_text;

import use_case.speech_to_text.SpeechToTextInputBoundary;
import use_case.speech_to_text.SpeechToTextInputData;

/**
 * The controller for handling speech input.
 * It coordinates between the user input (audio data) and the use case that converts speech to text.
 * It delegates processing to the use case and passes results to the presenter.
 */
public class SpeechToTextController {

    private final SpeechToTextInputBoundary speechToTextInputInteractor;  // Input Boundary

    /**
     * Constructs a SpeechToTextController with the given input and output boundaries.
     *
     * @param speechToTextInputInteractor  The boundary for processing the speech input.
     */
    public SpeechToTextController(SpeechToTextInputBoundary speechToTextInputInteractor) {
        this.speechToTextInputInteractor = speechToTextInputInteractor;
    }

    /**
     * Handles the speech input by processing the given audio data and returning the transcribed text.
     *
     * @param audioData The audio data in byte array format to be processed.
     */
    public void processSpeech(byte[] audioData) throws Exception {
        SpeechToTextInputData inputData = new SpeechToTextInputData(audioData);
        speechToTextInputInteractor.processSpeech(inputData);
    }
}
