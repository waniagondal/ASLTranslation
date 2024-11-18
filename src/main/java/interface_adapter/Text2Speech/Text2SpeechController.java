package interface_adapter.Text2Speech;

import entity.AudioParam;
import use_case.text2speech.Text2SpeechInputBoundary;
import use_case.text2speech.Text2SpeechInputData;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

/**
 * Controller for the Text to Speech Use Case.
 */
public class Text2SpeechController {
    private final Text2SpeechInputBoundary userText2SpeechUseCaseInteractor;


    public Text2SpeechController(Text2SpeechInputBoundary userText2SpeechUseCaseInteractor) {
        this.userText2SpeechUseCaseInteractor = userText2SpeechUseCaseInteractor;
    }

    /**
     * Executes the Text to Speech Use Case.
     * @param text the text
     * @param languageCode the language code
     * @param audioParam the settings for the audio
     */
    public void execute(String text, String languageCode, AudioParam audioParam) throws IOException, LineUnavailableException {
        final Text2SpeechInputData text2SpeechInputData = new Text2SpeechInputData(text, languageCode, audioParam);

        userText2SpeechUseCaseInteractor.execute(text2SpeechInputData);
    }
}
