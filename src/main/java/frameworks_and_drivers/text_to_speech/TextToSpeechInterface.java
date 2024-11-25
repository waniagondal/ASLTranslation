package frameworks_and_drivers.text_to_speech;

import use_case.text_to_speech.TextToSpeechInputData;
import use_case.text_to_speech.TextToSpeechOutputData;

import java.io.IOException;

/**
 * Defines the contract for the external service to convert text to speech.
 */
public interface TextToSpeechInterface {
    TextToSpeechOutputData convertTextToSpeech(TextToSpeechInputData inputData) throws IOException;
}

