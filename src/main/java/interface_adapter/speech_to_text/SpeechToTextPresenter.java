package interface_adapter.speech_to_text;

import interface_adapter.ViewInterface;
import use_case.speech_to_text.SpeechToTextOutputBoundary;
import use_case.speech_to_text.SpeechToTextOutputData;

/**
 * The Presenter that formats and delivers the transcription result to the UI.
 */
public class SpeechToTextPresenter implements SpeechToTextOutputBoundary {
    private final ViewInterface view;

    /**
     * Constructor for the SignLanguagePresenter.
     *
     * @param view the view that will display the recognition results
     */
    public SpeechToTextPresenter(ViewInterface view) {
        this.view = view;
    }

    /**
     * Delivers the transcribed text to the UI.
     * @param outputData the transcribed text to deliver.
     */
    @Override
    public void deliverTranscription(SpeechToTextOutputData outputData) {
        view.signLanguageTranscriptionDisplay(outputData.getTranscription());
    }
}
