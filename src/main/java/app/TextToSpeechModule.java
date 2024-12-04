package app;

import frameworks_and_drivers.text_to_speech.GoogleTextToSpeechGateway;
import interface_adapter.ViewInterface;
import interface_adapter.text_to_speech.TextToSpeechController;
import interface_adapter.text_to_speech.TextToSpeechInterface;
import interface_adapter.text_to_speech.TextToSpeechPresenter;
import use_case.text_to_speech.TextToSpeechInputBoundary;
import use_case.text_to_speech.TextToSpeechInteractor;
import use_case.text_to_speech.TextToSpeechOutputBoundary;

/**
 * This module initializes the Text-to-Speech (TTS) functionality, including the controller and related components.
 */
public class TextToSpeechModule {

    /**
     * Initializes the Text-to-Speech module, including the controller and services.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the TextToSpeechController instance.
     */
    public static TextToSpeechController initialize(ViewInterface gestureBridgeView) {
        final TextToSpeechInterface textToSpeechService = new GoogleTextToSpeechGateway();
        final TextToSpeechOutputBoundary outputBoundary = new TextToSpeechPresenter(gestureBridgeView);
        final TextToSpeechInputBoundary interactor = new TextToSpeechInteractor(outputBoundary, textToSpeechService);
        return new TextToSpeechController(interactor);
    }
}
