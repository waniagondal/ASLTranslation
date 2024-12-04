package interface_adapter.sign_language_recognition;

import use_case.sign_language_recognition.SignLanguageRecognitionOutputBoundary;
import use_case.sign_language_recognition.SignLanguageRecognitionOutputData;
import view.GestureBridgeView;
import view.ViewInterface;

/**
 * Presenter for handling the presentation logic of the sign language recognition.
 * Implements the Output Boundary to receive and process the recognition results.
 */
public class SignLanguagePresenter implements SignLanguageRecognitionOutputBoundary {

    private final ViewInterface view;

    /**
     * Constructor for the SignLanguagePresenter.
     *
     * @param view the view that will display the recognition results
     */
    // The generation here needs to be changed to take in the view interface instead of the view in place of the view model
    public SignLanguagePresenter(ViewInterface view) {
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
        // the view here needs to be changed into an interface object
        view.signLanguageRecognitionDisplay(outputData.getPrediction());
    }
}