package frameworks_and_drivers;

import interface_adapters.PredictionInterface;
import presenter.SignLanguagePresenter;
import use_case.PredictionService;
import view.SignLanguageView;
import controller.SignLanguageController;

import java.io.IOException;

public class RunSignLanguageApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        String pythonInterpreter = "python3";
        String scriptPath = "src/main/python/hand_gesture_recognition.py";

        PredictionInterface predictor = new PredictionService(pythonInterpreter, scriptPath);
        SignLanguageView signLanguageView = new SignLanguageView();
        SignLanguagePresenter signLanguagePresenter = new SignLanguagePresenter(signLanguageView, predictor);
        SignLanguageController signLanguageController = new SignLanguageController(signLanguagePresenter);
        signLanguageController.startRecognition();
    }
}


