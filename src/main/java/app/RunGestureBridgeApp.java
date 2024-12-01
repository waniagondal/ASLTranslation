package app;

import data_access.SignLanguageTranslationDataAccessObject;
import data_access.VoiceDataAccessObject;
import entity.AudioSettings;
import entity.AudioSettingsFactory;
import frameworks_and_drivers.speech_to_text.GoogleSpeechRecognizer;
import frameworks_and_drivers.text_to_speech.GoogleTextToSpeechGateway;
import frameworks_and_drivers.text_to_speech.TextToSpeechInterface;
import interface_adapter.customize_voice.CustomizeVoiceController;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;
import interface_adapter.customize_voice.CustomizeVoicePresenter;
import interface_adapter.sign_language_recognition.SignLanguageController;
import interface_adapter.sign_language_recognition.SignLanguagePresenter;
import interface_adapter.sign_language_translation.SignLanguageTranslationController;
import interface_adapter.sign_language_translation.SignLanguageTranslationPresenter;
import interface_adapter.speech_to_text.SpeechToTextController;
import interface_adapter.speech_to_text.SpeechToTextPresenter;
import interface_adapter.text_to_speech.TextToSpeechController;
import interface_adapter.text_to_speech.TextToSpeechPresenter;
import use_case.customize_voice.CustomizeVoiceInputBoundary;
import use_case.customize_voice.CustomizeVoiceInteractor;
import use_case.customize_voice.CustomizeVoiceOutputBoundary;
import use_case.sign_language_recognition.PredictionService;
import use_case.sign_language_recognition.SignLanguageRecognitionInteractor;
import use_case.sign_language_translation.SignLanguageTranslationInputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationInteractor;
import use_case.sign_language_translation.SignLanguageTranslationOutputBoundary;
import use_case.speech_to_text.SpeechToTextInteractor;
import use_case.text_to_speech.TextToSpeechInputBoundary;
import use_case.text_to_speech.TextToSpeechInteractor;
import use_case.text_to_speech.TextToSpeechOutputBoundary;
import view.GestureBridgeView;
import view.ViewInterface;
import view.VoiceSettingsView;

import java.io.IOException;

/**
 * Entry point for the Gesture Bridge application.
 * Initializes all components and starts the application workflow.
 */
public class RunGestureBridgeApp {
    private static GestureBridgeView gestureBridgeView;
    private static VoiceSettingsView voiceSettingsView;

    /**
     * Main method to initialize and start the Gesture Bridge application.
     *
     * @param args command-line arguments (not used).
     * @throws IOException if there is an I/O error during initialization.
     * @throws InterruptedException if interrupted during execution.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Initialize the view
        gestureBridgeView = initializeView();

        // Initialize the settings view here along with the main view, except set to invisible
        voiceSettingsView = initializeSettings();

        // Initialize components for various modules
        TextToSpeechController textToSpeechController = initializeTextToSpeech(gestureBridgeView);
        SpeechToTextController speechToTextController = initializeSpeechToText(gestureBridgeView);
        SignLanguageTranslationController translationController = initializeTranslation(gestureBridgeView);
        SignLanguageController signLanguageController = initializeSignLanguageRecognition(gestureBridgeView);

        // Set the customize voice controller here as well
        CustomizeVoiceController customizeVoiceController = initializeVoiceCustomization(gestureBridgeView, voiceSettingsView);

        // Set controllers in the view
        setControllers(gestureBridgeView, voiceSettingsView, textToSpeechController, speechToTextController,
                        translationController, customizeVoiceController);

        // Create the relationship between main view and settings view
        gestureBridgeView.setOnSettingsButtonClicked(() -> voiceSettingsView.openSettings());

        // Start Sign Language Recognition
        signLanguageController.startRecognition();
    }

    /**
     * Initializes the main view for the application.
     *
     * @return the initialized GestureBridgeView instance.
     */
    private static GestureBridgeView initializeView() {
        return new GestureBridgeView();
    }

    /**
     * Initializes the settings view for the application.
     * @return the initialized VoiceSettingsView instance.
     */
    private static VoiceSettingsView initializeSettings() {
        AudioSettings audioSettings = new AudioSettingsFactory().create(1.5, false, 6.0);
        return new VoiceSettingsView(audioSettings);
    }

    /**
     * Initializes the Text-to-Speech module.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the TextToSpeechController instance.
     */
    private static TextToSpeechController initializeTextToSpeech(ViewInterface gestureBridgeView) {
        TextToSpeechInterface textToSpeechService = new GoogleTextToSpeechGateway();
        TextToSpeechOutputBoundary outputBoundary = new TextToSpeechPresenter(gestureBridgeView);
        TextToSpeechInputBoundary interactor = new TextToSpeechInteractor(outputBoundary, textToSpeechService);
        return new TextToSpeechController(interactor);
    }

    /**
     * Initializes the Speech-to-Text module.
     *
     * @param gestureBridgeView the view interface that is implemented by the main view to interact with presenter.
     * @return the SpeechToTextController instance.
     */
    private static SpeechToTextController initializeSpeechToText(ViewInterface gestureBridgeView) {
        GoogleSpeechRecognizer speechRecognizer = new GoogleSpeechRecognizer();
        SpeechToTextPresenter presenter = new SpeechToTextPresenter(gestureBridgeView);
        SpeechToTextInteractor interactor = new SpeechToTextInteractor(speechRecognizer, presenter);
        return new SpeechToTextController(interactor);
    }

    /**
     * Initializes the Sign Language Translation module.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the SignLanguageTranslationController instance.
     */
    private static SignLanguageTranslationController initializeTranslation(GestureBridgeView gestureBridgeView) {
        SignLanguageTranslationDataAccessObject dataAccessObject = new SignLanguageTranslationDataAccessObject();
        SignLanguageTranslationOutputBoundary outputBoundary = new SignLanguageTranslationPresenter(gestureBridgeView);
        SignLanguageTranslationInputBoundary interactor = new SignLanguageTranslationInteractor(dataAccessObject, outputBoundary);
        return new SignLanguageTranslationController(interactor);
    }

    /**
     * Initializes the Sign Language Recognition module.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the SignLanguageController instance.
     */
    private static SignLanguageController initializeSignLanguageRecognition(GestureBridgeView gestureBridgeView) {
        String pythonInterpreter = "python3";
        String scriptPath = "src/main/python/hand_gesture_recognition.py";
        PredictionService predictor = new PredictionService(pythonInterpreter, scriptPath);
        SignLanguagePresenter presenter = new SignLanguagePresenter(gestureBridgeView);
        SignLanguageRecognitionInteractor interactor = new SignLanguageRecognitionInteractor(predictor, presenter);
        return new SignLanguageController(interactor);
    }

    /**
     * Initializes the Voice Customization module.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @param settingsView the text to speech settings view for communication with presenters.
     * @return the CustomVoiceController instance.
     */
    private static CustomizeVoiceController initializeVoiceCustomization(GestureBridgeView gestureBridgeView, VoiceSettingsView settingsView) {
        AudioSettingsFactory audioSettingsFactory = new AudioSettingsFactory();
        CustomizeVoiceDataAccessInterface dataAccessObject = new VoiceDataAccessObject();
        CustomizeVoiceOutputBoundary outputBoundary = new CustomizeVoicePresenter(gestureBridgeView, settingsView);
        CustomizeVoiceInputBoundary interactor = new CustomizeVoiceInteractor(dataAccessObject, outputBoundary,
                audioSettingsFactory);
        return new CustomizeVoiceController(interactor);
    }


    /**
     * Sets the controllers in the main application view.
     *
     * @param view the main application view.
     * @param voiceSettingsView the settings view.
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
        view.setSpeechToTextController(speechToTextController);
        view.setTranslationController(translationController);
        voiceSettingsView.setCustomizeVoiceController(customizeVoiceController);
    }
}
