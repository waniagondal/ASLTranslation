package use_case.text2speech;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

/**
 * The output data for the Text to Speech Use Case.
 */
public interface Text2SpeechOutputBoundary {
    /**
     * Prepares the success view for the Text to Speech Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(Text2SpeechOutputData outputData) throws LineUnavailableException, IOException;

    void prepareFailView(String error);
}
