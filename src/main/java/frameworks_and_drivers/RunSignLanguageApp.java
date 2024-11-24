package frameworks_and_drivers;

import interface_adapter.PredictionInterface;
import presenter.SignLanguagePresenter;
import use_case.PredictionService;
import view.SignLanguageView;
import controller.SignLanguageController;
import controller.SpeechtoTextController;
import frameworks_and_drivers.Speech2Text.GoogleSpeechRecognizer;
import use_case.Speech2Text.ProcessSpeechInputUseCase;

import java.io.IOException;

public class RunSignLanguageApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        String pythonInterpreter = "python3";
        String scriptPath = "src/main/python/hand_gesture_recognition.py";

        GoogleSpeechRecognizer speechRecognizer = new GoogleSpeechRecognizer();
        ProcessSpeechInputUseCase speechInputUseCase = new ProcessSpeechInputUseCase(speechRecognizer);
        SpeechtoTextController speechToTextController = new SpeechtoTextController(speechInputUseCase);

        PredictionInterface predictor = new PredictionService(pythonInterpreter, scriptPath);
        SignLanguageView signLanguageView = new SignLanguageView(speechToTextController);

        SignLanguagePresenter signLanguagePresenter = new SignLanguagePresenter(signLanguageView, predictor);
        SignLanguageController signLanguageController = new SignLanguageController(signLanguagePresenter);
        signLanguageController.startRecognition();
    }
}


