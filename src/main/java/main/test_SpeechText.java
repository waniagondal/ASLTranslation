package main;

import controllers.SpeechtoTextController;
import frameworks_and_drivers.GoogleSpeechRecognizer;
import use_case.ProcessSpeechInputUseCase;
import view.SpeechTextUItest;


public class test_SpeechText {
    public static void main(String[] args) {

        GoogleSpeechRecognizer speechRecognizer =
                new GoogleSpeechRecognizer();

        ProcessSpeechInputUseCase speechInputUseCase =
                new ProcessSpeechInputUseCase(speechRecognizer);

        SpeechtoTextController controller =
                new SpeechtoTextController(speechInputUseCase);

        new SpeechTextUItest(controller);
    }
}
