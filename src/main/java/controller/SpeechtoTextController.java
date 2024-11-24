package controller;

import use_case.Speech2Text.ProcessSpeechInputUseCase;
import entity.AudioTranscription;

/**
 * The SpeechtoTextController class serves as the controller in the application,
 * coordinating the flow between user input and the speech-to-text use case.
 * It processes audio data and returns the transcribed text.
 */
public class SpeechtoTextController {
    /**
     * The use case for processing speech input and converting it into text.
     */
    private final ProcessSpeechInputUseCase speechInputUseCase;
    /**
     * Constructs a SpeechtoTextController with the given use case.
     *
     * @param speechInputUseCase The use case responsible for processing speech input.
     */

    public SpeechtoTextController(
            ProcessSpeechInputUseCase speechInputUseCase) {
        this.speechInputUseCase = speechInputUseCase;
    }
    /**
     * Handles the speech input by processing the given audio data and returning the transcribed text.
     *
     * @param audioData The audio data in byte array format to be processed.
     * @return The transcribed text from the audio data, or an error message if processing fails.
     */

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