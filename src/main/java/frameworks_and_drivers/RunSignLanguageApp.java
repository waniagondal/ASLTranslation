//package frameworks_and_drivers;
//
//import frameworks_and_drivers.speech_to_text.GoogleSpeechRecognizer;
//import interface_adapter.sign_language_recognition.PredictionInterface;
//import interface_adapter.sign_language_translation.TranslationViewModel;
//import interface_adapter.sign_language_recognition.SignLanguagePresenter;
//import interface_adapter.speech_to_text.SpeechToTextController;
//import interface_adapter.speech_to_text.SpeechToTextPresenter;
//import use_case.sign_language_recognition.PredictionService;
//import use_case.sign_language_recognition.SignLanguageRecognitionInteractor;
//import view.SignLanguageView;
//import interface_adapter.sign_language_recognition.SignLanguageController;
//import interface_adapter.speech_to_text.SpeechToTextController;
//import use_case.speech_to_text.SpeechToTextInteractor;
//
//import data_access.TranslationDataAccessObject;
//import interface_adapter.sign_language_translation.TranslationController;
//import interface_adapter.sign_language_translation.TranslationPresenter;
//import use_case.sign_language_translation.TranslationInputBoundary;
//import use_case.sign_language_translation.TranslationInteractor;
//import use_case.sign_language_translation.TranslationOutputBoundary;
//
//import java.io.IOException;
//
//public class RunSignLanguageApp {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // Path to Python interpreter and the script for gesture recognition
//        String pythonInterpreter = "python3";
//        String scriptPath = "src/main/python/hand_gesture_recognition.py";
//
//        // Initialize the speech recognition system
//        GoogleSpeechRecognizer speechRecognizer = new GoogleSpeechRecognizer();
//
//
//        // Initialize the controller that uses the speech input use case
//        SpeechToTextController speechToTextController = new SpeechToTextController(speechInputUseCase);
//
//        // Initialize the translation view model
//        TranslationViewModel translationViewModel = new TranslationViewModel();
//
//        // Initialize the SignLanguageView, passing in the controllers
//        SignLanguageView signLanguageView = new SignLanguageView(speechToTextController, translationViewModel);
//
//        SpeechToTextPresenter speechToTextPresenter = new SpeechToTextPresenter(signLanguageView);
//
//        // Initialize the use case for processing speech input
//        SpeechToTextInteractor speechInputUseCase = new SpeechToTextInteractor(speechRecognizer, speechToTextPresenter);
//
//
//
//        // Create translation-related objects: OutputBoundary, DAO, and InputBoundary
//        final TranslationOutputBoundary translationOutputBoundary = new TranslationPresenter(translationViewModel);
//        final TranslationDataAccessObject languageDataAccessObject = new TranslationDataAccessObject();
//        final TranslationInputBoundary selectLanguageInteractor = new TranslationInteractor(
//                languageDataAccessObject, translationOutputBoundary);
//
//        // Initialize the TranslationController, passing in the input boundary
//        final TranslationController translationController = new TranslationController(selectLanguageInteractor);
//
//        // Set the translation controller for the view
//        signLanguageView.setSelectLanguageController(translationController);
//
//        // Initialize the gesture prediction service
//        PredictionInterface predictor = new PredictionService(pythonInterpreter, scriptPath);
//
//        // Initialize the presenter, passing in the view to it
//        SignLanguagePresenter signLanguagePresenter = new SignLanguagePresenter(signLanguageView);
//
//        // Create the use case for sign language recognition
//        SignLanguageRecognitionInteractor signLanguageRecognitionInteractor = new SignLanguageRecognitionInteractor(predictor, signLanguagePresenter);
//
//        SignLanguageController signLanguageController = new SignLanguageController(signLanguageRecognitionInteractor);
//
//        // Start the sign language recognition process
//        signLanguageController.startRecognition();
//    }
//}
//
//
