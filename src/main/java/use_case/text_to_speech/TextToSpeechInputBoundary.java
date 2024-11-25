package use_case.text_to_speech;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

/**
 * Defines the contract for the Text-to-Speech use case.
 */
public interface TextToSpeechInputBoundary {

    /**
     * Execute the Text to Speech Use Case.
     * @param TextToSpeechInputData The input data for the Text to Speech Use Case.
     */
    void execute(TextToSpeechInputData TextToSpeechInputData) throws IOException, LineUnavailableException;

}