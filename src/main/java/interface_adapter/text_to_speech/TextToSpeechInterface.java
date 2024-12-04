package interface_adapter.text_to_speech;

import java.io.IOException;

import use_case.text_to_speech.TextToSpeechInputData;
import use_case.text_to_speech.TextToSpeechOutputData;

/**
 * Defines the contract for an external service responsible for converting text to speech.
 * This interface specifies a method for converting text to speech, allowing different implementations
 * to be used for various text-to-speech services.
 */
public interface TextToSpeechInterface {

    /**
     * Converts the given text input into speech.
     *
     * @param inputData The input data containing the text and settings to be converted into speech.
     * @return The output data containing the generated speech.
     * @throws IOException If there is an error during the conversion process (e.g., network or file issues).
     */
    TextToSpeechOutputData convertTextToSpeech(TextToSpeechInputData inputData) throws IOException;
}
