package use_case.sign_language_recognition;

/**
 * This interface defines the contract for updating the UI or Presenter
 * with the result of the sign language recognition process.
 */
public interface SignLanguageRecognitionOutputBoundary {
    void updateView(SignLanguageRecognitionOutputData outputData);
}
