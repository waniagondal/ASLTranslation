package use_case.sign_language_recognition;

/**
 * This interface defines the contract for updating the UI or Presenter
 * with the result of the sign language recognition process.
 * It is responsible for providing the output data to the presenter
 * or view for display or further processing.
 */
public interface SignLanguageRecognitionOutputBoundary {

    /**
     * Updates the view with the result of the sign language recognition process.
     *
     * @param outputData The output data containing the results of the sign language recognition.
     */
    void updateView(SignLanguageRecognitionOutputData outputData);
}
