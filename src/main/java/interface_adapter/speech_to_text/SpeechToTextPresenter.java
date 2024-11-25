package interface_adapter.speech_to_text;

import use_case.speech_to_text.SpeechToTextOutputBoundary;
import use_case.speech_to_text.SpeechToTextOutputData;
import view.SignLanguageView;

/**
 * The Presenter that formats and delivers the transcription result to the UI.
 */
public class SpeechToTextPresenter implements SpeechToTextOutputBoundary {
    private final SignLanguageView view;

    /**
     * Constructor for the SignLanguagePresenter.
     *
     * @param view the view that will display the recognition results
     */
    public SpeechToTextPresenter(SignLanguageView view) {
        this.view = view;
    }

    /**
     * Delivers the transcribed text to the UI.
     *
     * @param outputData the transcribed text to deliver.
     */
    @Override
    public void deliverTranscription(SpeechToTextOutputData outputData) {
        view.updateTranscriptionText(outputData.getTranscription());
    }
}