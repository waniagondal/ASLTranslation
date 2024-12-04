package use_case.text_to_speech;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import interface_adapter.text_to_speech.TextToSpeechInterface;

/**
 * Interactor for the Text-to-Speech use case. Contains the business logic for converting text to speech.
 */
public class TextToSpeechInteractor implements TextToSpeechInputBoundary {

    private final TextToSpeechOutputBoundary textToSpeechPresenter;
    private final TextToSpeechInterface textToSpeechService;

    /**
     * Constructs a TextToSpeechInteractor with the specified presenter and service.
     *
     * @param textToSpeechPresenter the output boundary responsible for presenting the text-to-speech results.
     * @param textToSpeechInterface the service interface for converting text into speech audio.
     */
    public TextToSpeechInteractor(
            TextToSpeechOutputBoundary textToSpeechPresenter, TextToSpeechInterface textToSpeechInterface) {
        this.textToSpeechPresenter = textToSpeechPresenter;
        this.textToSpeechService = textToSpeechInterface;
    }

    /**
     * Executes the Text-to-Speech use case.
     *
     * @param inputData the input data containing the text and audio configuration parameters for conversion.
     * @throws IOException if an I/O error occurs during the text-to-speech conversion process.
     * @throws LineUnavailableException if there is an issue with the audio playback line being unavailable.
     */
    @Override
    public void execute(TextToSpeechInputData inputData) throws IOException, LineUnavailableException {
        // Delegating the external call to the gateway (Google Cloud integration)
        final TextToSpeechOutputData outputData = textToSpeechService.convertTextToSpeech(inputData);
        textToSpeechPresenter.prepareOutput(outputData);
    }
}
