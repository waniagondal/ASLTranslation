package interface_adapter.text_to_speech;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import interface_adapter.ViewInterface;
import use_case.text_to_speech.TextToSpeechOutputBoundary;
import use_case.text_to_speech.TextToSpeechOutputData;

/**
 * Responsible for presenting the output of the Text-to-Speech use case.
 */
public class TextToSpeechPresenter implements TextToSpeechOutputBoundary {
    private final ViewInterface view;

    /**
     * Constructs a TextToSpeechPresenter.
     *
     * @param view the view that will play the generated speech audio
     */
    public TextToSpeechPresenter(ViewInterface view) {
        this.view = view;
    }

    /**
     * Delivers the output audio produced from the text-to-speech conversion to the UI.
     *
     * @param outputData the output data containing the audio contents to be played
     * @throws LineUnavailableException if there is an issue with the audio line being unavailable
     * @throws IOException if an I/O error occurs while playing the audio
     */
    @Override
    public void prepareOutput(TextToSpeechOutputData outputData) throws LineUnavailableException, IOException {
        view.playAudio(outputData.getAudioContents());
    }
}
