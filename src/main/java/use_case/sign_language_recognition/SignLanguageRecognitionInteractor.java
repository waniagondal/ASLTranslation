package use_case.sign_language_recognition;

import java.io.IOException;

/**
 * Use case for starting the recognition of sign language gestures.
 */
public class SignLanguageRecognitionInteractor {
    private final PredictionService predictor;
    private final SignLanguageRecognitionOutputBoundary signLanguagePresenter;

    /**
     * Constructor for the SignLanguageRecognitionUseCase.
     *
     * @param predictor the PredictionService that will perform the recognition
     * @param outputBoundary the Output Boundary to update the presenter/view
     */
    public SignLanguageRecognitionInteractor(
            PredictionService predictor, SignLanguageRecognitionOutputBoundary outputBoundary) {
        this.predictor = predictor;
        this.signLanguagePresenter = outputBoundary;
    }

    /**
     * Starts the recognition process.
     *
     * @throws IOException if there is an error with the input/output operation
     * @throws InterruptedException if the thread is interrupted during the operation
     */
    public void startRecognition() throws IOException, InterruptedException {
        predictor.startRecognition(this::predictionToPresenter);
    }

    /**
     * Method to update the view with the prediction result, through sending output data over to the presenter.
     *
     * @param prediction The prediction result from the recognition process.
     */
    private void predictionToPresenter(String prediction) {
        final SignLanguageRecognitionOutputData outputData = new SignLanguageRecognitionOutputData(prediction);
        signLanguagePresenter.updateView(outputData);
    }
}
