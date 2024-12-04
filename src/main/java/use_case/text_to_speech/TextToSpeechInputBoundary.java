package use_case.text_to_speech;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

/**
 * Defines the contract for the Text-to-Speech use case.
 */
public interface TextToSpeechInputBoundary {

    /**
     * Executes the Text-to-Speech use case.
     * This method processes the provided input data, which contains the text to be converted
     * and associated configuration settings. It initiates the text-to-speech conversion process
     * and prepares the resulting audio for playback or further use.
     *
     * @param TextToSpeechInputData the data containing the generated audio content to be processed
     * @throws LineUnavailableException if there is an issue with the audio line being unavailable
     * @throws IOException if an I/O error occurs while processing the audio
     */
    void execute(TextToSpeechInputData TextToSpeechInputData) throws IOException, LineUnavailableException;
}
