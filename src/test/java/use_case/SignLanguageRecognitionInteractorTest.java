package use_case;

import interface_adapter.sign_language_recognition.PredictionInterface;
import org.junit.jupiter.api.Test;
import use_case.sign_language_recognition.SignLanguageRecognitionInteractor;
import use_case.sign_language_recognition.SignLanguageRecognitionOutputBoundary;
import use_case.sign_language_recognition.PredictionService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This tests only tests the interactor, which deals with the predictions of the python model
// This test reached 100% coverage for interactor.
// For the sake of simplicity and testing, the python model part is not tested through Java unit tests
// Instead, their accuracy is tested by manually signing out gestures and checking the output result, alongside
// finding the confidence score, which ended up being 92% through ML validatoion in pytroch.
class SignLanguageRecognitionInteractorTest {

    @Test
    void testPredictionToPresenter() throws IOException, InterruptedException {
        // Mock the PredictionInterface to simulate receiving the letter "a"
        PredictionInterface mockPredictor = listener -> {
            // Simulate prediction being called with the letter "a"
            listener.onPrediction("a");
        };

        // Mock the presenter to test out the display of output data
        SignLanguageRecognitionInteractor interactor = getSignLanguageRecognitionInteractor(mockPredictor);
        interactor.startRecognition();  // This will trigger the prediction process
    }

    private static SignLanguageRecognitionInteractor getSignLanguageRecognitionInteractor(
            PredictionInterface mockPredictor) {
        SignLanguageRecognitionOutputBoundary mockPresenter = outputData -> {
            // Assert that the received prediction is the letter "a"
            assertEquals("a", outputData.getPrediction());
        };

        // Use the PredictionService in the interactor
        PredictionService mockPredictionService = new PredictionService(mockPredictor);

        return new SignLanguageRecognitionInteractor(mockPredictionService, mockPresenter);
    }
}
