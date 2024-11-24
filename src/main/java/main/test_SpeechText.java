package main;

import controller.SpeechtoTextController;
import frameworks_and_drivers.Speech2Text.GoogleSpeechRecognizer;
import use_case.Speech2Text.ProcessSpeechInputUseCase;
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
