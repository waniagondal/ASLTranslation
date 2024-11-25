package use_case.text_to_speech;

import frameworks_and_drivers.text_to_speech.TextToSpeechInterface;

import java.io.IOException;

/**
 * Interactor for the Text-to-Speech use case. Contains the business logic for converting text to speech.
 */
public class TextToSpeechInteractor implements TextToSpeechInputBoundary {

    private final TextToSpeechOutputBoundary outputBoundary;
    private final TextToSpeechInterface textToSpeechService;

    public TextToSpeechInteractor(TextToSpeechOutputBoundary outputBoundary, TextToSpeechInterface textToSpeechInterface) {
        this.outputBoundary = outputBoundary;
        this.textToSpeechService = textToSpeechInterface;
    }

    @Override
    public void execute(TextToSpeechInputData inputData) throws IOException {
        // Delegating the external call to the gateway (Google Cloud integration)
        TextToSpeechOutputData outputData = textToSpeechService.convertTextToSpeech(inputData);
        outputBoundary.prepareOutput(outputData);
    }
}
