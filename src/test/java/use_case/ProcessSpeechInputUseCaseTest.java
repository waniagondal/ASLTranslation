package use_case;

import interface_adapter.PredictionInterface;
import presenter.SignLanguagePresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SignLanguageRecognitionUseCase.
 */
public class SignLanguageRecognitionUseCaseTest {

    private SignLanguageRecognitionUseCase useCase;
    private PredictionInterface mockPredictor;
    private SignLanguagePresenter mockPresenter;

    @BeforeEach
    public void setUp() {
        // Mock PredictionInterface
        mockPredictor = mock(PredictionInterface.class);

        // Mock SignLanguagePresenter
        mockPresenter = mock(SignLanguagePresenter.class);

        // Initialize the SignLanguageRecognitionUseCase with mocked dependencies
        useCase = new SignLanguageRecognitionUseCase(mockPredictor, mockPresenter);
    }

    @Test
    public void testStartRecognition_Success() throws IOException, InterruptedException {
        // Arrange: Simulate that the predictor will pass a prediction (e.g., "A")
        doNothing().when(mockPredictor).startRecognition(any());

        // Act: Call startRecognition which should call the presenter with the predicted value
        useCase.startRecognition();

        // Assert: Verify that the presenter was called with the correct prediction ("A")
        verify(mockPredictor).startRecognition(any());
        verify(mockPresenter).updateView("A");
    }

    @Test
    public void testStartRecognition_ExceptionHandling_IOException() throws IOException, InterruptedException {
        // Arrange: Simulate the predictor throwing an IOException
        doThrow(new IOException("Prediction failed")).when(mockPredictor).startRecognition(any());

        // Act & Assert: Ensure that an IOException is thrown when calling startRecognition
        IOException exception = assertThrows(IOException.class, () -> useCase.startRecognition());

        // Assert: Verify the exception message
        assertEquals("Prediction failed", exception.getMessage());
    }

    @Test
    public void testStartRecognition_ExceptionHandling_InterruptedException() throws IOException, InterruptedException {
        // Arrange: Simulate the predictor throwing an InterruptedException
        doThrow(new InterruptedException("Thread interrupted")).when(mockPredictor).startRecognition(any());

        // Act & Assert: Ensure that an InterruptedException is thrown when calling startRecognition
        InterruptedException exception = assertThrows(InterruptedException.class, () -> useCase.startRecognition());

        // Assert: Verify the exception message
        assertEquals("Thread interrupted", exception.getMessage());
    }

    @Test
    public void testPredictionPassedToPresenter() throws IOException, InterruptedException {
        // Arrange: Simulate the predictor returning the prediction "B"
        doNothing().when(mockPredictor).startRecognition(any());

        // Act: Call startRecognition to trigger the prediction process
        useCase.startRecognition();

        // Assert: Verify that the presenter is updated with the correct prediction
        verify(mockPresenter).updateView("B");
    }
}
