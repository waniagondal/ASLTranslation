package app;

import frameworks_and_drivers.sign_language_recognition.PythonScriptRunner;
import interface_adapter.sign_language_recognition.PredictionInterface;
import interface_adapter.sign_language_recognition.SignLanguageRecognitionController;
import interface_adapter.sign_language_recognition.SignLanguageRecognitionPresenter;
import use_case.sign_language_recognition.PredictionService;
import use_case.sign_language_recognition.SignLanguageRecognitionInteractor;
import use_case.sign_language_recognition.SignLanguageRecognitionOutputBoundary;
import view.GestureBridgeView;

/**
 * This module initializes the Sign Language Recognition functionality, including
 * the controller and related components.
 */
public class SignLanguageRecognitionModule {

    /**
     * Initializes the Sign Language Recognition module, including the controller and services.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the SignLanguageController instance.
     */
    public static SignLanguageRecognitionController initialize(GestureBridgeView gestureBridgeView) {
        final String pythonInterpreter = "python3";
        final String scriptPath = "src/main/python/hand_gesture_recognition.py";
        final PredictionInterface predictionInterface = new PythonScriptRunner(pythonInterpreter, scriptPath);
        final PredictionService predictionService = new PredictionService(predictionInterface);
        final SignLanguageRecognitionOutputBoundary outputBoundary = new SignLanguageRecognitionPresenter(
                gestureBridgeView);
        final SignLanguageRecognitionInteractor interactor = new SignLanguageRecognitionInteractor(
                predictionService, outputBoundary);
        return new SignLanguageRecognitionController(interactor);
    }
}
