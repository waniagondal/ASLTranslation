package interface_adapter.text_to_speech;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import entity.AudioSettings;
import use_case.text_to_speech.TextToSpeechInputBoundary;
import use_case.text_to_speech.TextToSpeechInputData;

/**
 * Controller for the Text to Speech Use Case.
 * This class manages the interaction between the UI and the core use case logic
 * for converting text to speech based on provided settings and language.
 */
public class TextToSpeechController {
    private final TextToSpeechInputBoundary textToSpeechInteractor;

    /**
     * Constructs a TextToSpeechController with the provided interactor.
     *
     * @param textToSpeechInteractor the interactor that processes text to speech conversion
     */
    public TextToSpeechController(TextToSpeechInputBoundary textToSpeechInteractor) {
        this.textToSpeechInteractor = textToSpeechInteractor;
    }

    /**
     * Executes the Text to Speech Use Case, converting the provided text to speech.
     * It uses the specified language code and audio settings for the conversion process.
     *
     * @param text the text to be converted to speech
     * @param languageCode the language code for the speech conversion (e.g., "en-US")
     * @param audioSettings the settings for the audio (such as volume, speed, and pitch)
     * @throws IOException if there is an issue reading the audio data or processing the text
     * @throws LineUnavailableException if there is an issue with the audio line, such as being unavailable
     */
    public void execute(String text, String languageCode, AudioSettings audioSettings)
            throws IOException, LineUnavailableException {
        final TextToSpeechInputData textToSpeechInputData = new TextToSpeechInputData(
                text, languageCode, audioSettings);
        textToSpeechInteractor.execute(textToSpeechInputData);
    }
}
