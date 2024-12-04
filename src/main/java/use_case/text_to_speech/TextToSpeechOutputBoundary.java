package use_case.text_to_speech;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

/**
 * Defines the contract for the output boundary of the Text-to-Speech use case.
 */
public interface TextToSpeechOutputBoundary {

    /**
     * Prepares the output data from the Text-to-Speech use case.
     *
     * @param outputData the data containing the generated audio content to be processed
     * @throws LineUnavailableException if there is an issue with the audio line being unavailable
     * @throws IOException if an I/O error occurs while processing the audio
     */
    void prepareOutput(TextToSpeechOutputData outputData) throws LineUnavailableException, IOException;
}
