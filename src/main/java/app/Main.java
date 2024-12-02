package app;

import java.io.IOException;

import frameworks_and_drivers.speech_to_text.MicrophoneAudioRecorder;
import interface_adapter.customize_voice.CustomizeVoiceController;
import interface_adapter.sign_language_recognition.SignLanguageController;
import interface_adapter.sign_language_translation.SignLanguageTranslationController;
import interface_adapter.speech_to_text.SpeechToTextController;
import interface_adapter.text_to_speech.TextToSpeechController;
import view.GestureBridgeView;
import view.VoiceSettingsView;

/**
 * Entry point for the Gesture Bridge application.
 * Initializes all components and starts the application workflow.
 */
public class Main {
    private static final MicrophoneAudioRecorder audioRecorder = new MicrophoneAudioRecorder();

    /**
     * Sets the controllers in the main application view.
     *
     * @param view the main application view.
     * @param voiceSettingsView the settings view for voice configuration.
     * @param textToSpeechController the controller for the Text-to-Speech module.
     * @param speechToTextController the controller for the Speech-to-Text module.
     * @param translationController the controller for the Sign Language Translation module.
     * @param customizeVoiceController the controller for the Voice Customization module.
     */
    private static void setControllers(
            GestureBridgeView view,
            VoiceSettingsView voiceSettingsView,
            TextToSpeechController textToSpeechController,
            SpeechToTextController speechToTextController,
            SignLanguageTranslationController translationController,
            CustomizeVoiceController customizeVoiceController
    ) {
        view.setTextToSpeechController(textToSpeechController);
        view.setSpeechToTextController(speechToTextController, audioRecorder);
        view.setTranslationController(translationController);
        voiceSettingsView.setCustomizeVoiceController(customizeVoiceController);
    }

    /**
     * Main method to initialize and start the Gesture Bridge application.
     *
     * @param args command-line arguments (not used).
     * @throws IOException if there is an I/O error during initialization.
     * @throws InterruptedException if interrupted during execution.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GestureBridgeView gestureBridgeView = ViewInitializationModule.initializeView();
        final VoiceSettingsView voiceSettingsView = ViewInitializationModule.initializeVoiceSettingsView();

        final TextToSpeechController textToSpeechController = TextToSpeechModule.initialize(gestureBridgeView);
        final SpeechToTextController speechToTextController = SpeechToTextModule.initialize(gestureBridgeView);
        final SignLanguageTranslationController translationController = SignLanguageTranslationModule.initialize(
                gestureBridgeView);
        final SignLanguageController recognitionController = SignLanguageRecognitionModule.initialize(
                gestureBridgeView);
        final CustomizeVoiceController voiceController = VoiceCustomizationModule.initialize(
                gestureBridgeView, voiceSettingsView);

        setControllers(gestureBridgeView, voiceSettingsView, textToSpeechController,
                speechToTextController, translationController, voiceController);

        gestureBridgeView.setOnSettingsButtonClicked(voiceSettingsView::openSettings);

        recognitionController.startRecognition();
    }
}
