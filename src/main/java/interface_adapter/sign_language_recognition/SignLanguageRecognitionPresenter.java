package interface_adapter.sign_language_recognition;

import interface_adapter.ViewInterface;
import use_case.sign_language_recognition.SignLanguageRecognitionOutputBoundary;
import use_case.sign_language_recognition.SignLanguageRecognitionOutputData;

/**
 * Presenter for handling the presentation logic of the sign language recognition.
 */
public class SignLanguageRecognitionPresenter implements SignLanguageRecognitionOutputBoundary {

    private final ViewInterface view;

    /**
     * Constructor for the SignLanguagePresenter.
     *
     * @param view the view that will display the recognition results
     */
    public SignLanguageRecognitionPresenter(ViewInterface view) {
        this.view = view;
    }

    /**
     * Update the view with the recognition result (prediction).
     * This method is called when the use case finishes processing the recognition.
     *
     * @param outputData the data containing the recognition result
     */
    @Override
    public void updateView(SignLanguageRecognitionOutputData outputData) {
        view.signLanguageRecognitionDisplay(outputData.getPrediction());
    }
}
