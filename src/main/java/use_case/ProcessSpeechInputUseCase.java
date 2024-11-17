package use_case;

import entities.AudioTranscription;
import interface_adapters.SpeechInputBoundary;
import interface_adapters.SpeechRecognizer;

public class ProcessSpeechInputUseCase implements SpeechInputBoundary {
    private final SpeechRecognizer speechRecognizer;

    public ProcessSpeechInputUseCase(SpeechRecognizer speechRecognizer) {
        this.speechRecognizer = speechRecognizer;
    }

    @Override
    public AudioTranscription processSpeech(byte[] audioData) throws Exception {
        String text = speechRecognizer.recognize(audioData);
        return new AudioTranscription(text);
    }
}
