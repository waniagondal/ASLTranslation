package controllers;

import use_case.ProcessSpeechInputUseCase;
import entities.AudioTranscription;


public class SpeechtoTextController {
    private final ProcessSpeechInputUseCase speechInputUseCase;

    public SpeechtoTextController(
            ProcessSpeechInputUseCase speechInputUseCase) {
        this.speechInputUseCase = speechInputUseCase;
    }

    public String handleSpeechInput(byte[] audioData) {
        try {
            AudioTranscription transcription = speechInputUseCase
                    .processSpeech(audioData);
            return transcription.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing speech input.";
        }
    }
}