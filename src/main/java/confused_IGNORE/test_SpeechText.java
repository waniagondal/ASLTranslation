//package confused;
//
//import frameworks_and_drivers.speech_to_text.GoogleSpeechRecognizer;
//import interface_adapter.speech_to_text.SpeechtoTextController;
//import use_case.speech_to_text.SpeechToTextInteractor;
//import view.SpeechTextUItest;
//
//
//public class test_SpeechText {
//    public static void main(String[] args) {
//
//        GoogleSpeechRecognizer speechRecognizer =
//                new GoogleSpeechRecognizer();
//
//        SpeechToTextInteractor speechInputUseCase =
//                new SpeechToTextInteractor(speechRecognizer);
//
//        SpeechtoTextController controller =
//                new SpeechtoTextController(speechInputUseCase);
//
//        new SpeechTextUItest(controller);
//    }
//}
