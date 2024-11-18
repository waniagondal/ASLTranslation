package use_case.text2speech;

import java.io.IOException;

/**
 * The Text to Speech Use Case
 */
public interface Text2SpeechInputBoundary {
    /**
     * Execute the Text to Speech Use Case.
     * @param Text2SpeechInputData The input data for the Text to Speech Use Case.
     */
    void execute(Text2SpeechInputData Text2SpeechInputData) throws IOException;

}