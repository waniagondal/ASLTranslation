package interface_adapter.sign_language_recognition;

import use_case.sign_language_recognition.SignLanguageRecognitionInteractor;
import java.io.IOException;

/**
 * Controller for handling sign language recognition.
 */
public class SignLanguageController {

    private final SignLanguageRecognitionInteractor recognitionUseCase;

    /**
     * Constructor for the SignLanguageController.
     *
     * @param recognitionUseCase the use case that will handle the recognition process
     */
    public SignLanguageController(SignLanguageRecognitionInteractor recognitionUseCase) {
        this.recognitionUseCase = recognitionUseCase;
    }

    /**
     * Starts the sign language recognition process.
     *
     * @throws IOException if there is an error with the input/output operation
     * @throws InterruptedException if the thread is interrupted during the operation
     */
    public void startRecognition() throws IOException, InterruptedException {
        recognitionUseCase.startRecognition();
    }
}
