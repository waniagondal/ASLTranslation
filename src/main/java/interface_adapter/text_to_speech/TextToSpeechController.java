package interface_adapter.text_to_speech;

import entity.AudioSettings;
import use_case.text_to_speech.TextToSpeechInputBoundary;
import use_case.text_to_speech.TextToSpeechInputData;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

/**
 * Controller for the Text to Speech Use Case.
 */
public class TextToSpeechController {
    private final TextToSpeechInputBoundary textToSpeechInteractor;


    public TextToSpeechController(TextToSpeechInputBoundary textToSpeechInteractor) {
        this.textToSpeechInteractor = textToSpeechInteractor;
    }

    /**
     * Executes the Text to Speech Use Case.
     * @param text the text
     * @param languageCode the language code
     * @param audioSettings the settings for the audio
     */
    public void execute(String text, String languageCode, AudioSettings audioSettings) throws IOException, LineUnavailableException {
        final TextToSpeechInputData textToSpeechInputData = new TextToSpeechInputData(text, languageCode, audioSettings);
        textToSpeechInteractor.execute(textToSpeechInputData);
    }
}
