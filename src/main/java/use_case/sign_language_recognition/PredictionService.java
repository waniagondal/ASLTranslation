package use_case.sign_language_recognition;

import java.io.IOException;

import interface_adapter.sign_language_recognition.PredictionInterface;
import interface_adapter.sign_language_recognition.PredictionListenerInterface;

/**
 * Service for managing predictions using the PythonScriptRunner.
 */
public class PredictionService {
    private final PredictionInterface scriptRunner;

    /**
     * Constructs a new PredictionService with the specified script runner.
     *
     * @param scriptRunner the {@link PredictionInterface} implementation used for running predictions
     */
    public PredictionService(PredictionInterface scriptRunner) {
        this.scriptRunner = scriptRunner;
    }

    /**
     * Starts the sign language recognition process.
     *
     * @param listener the {@link PredictionListenerInterface} implementation that handles prediction results
     * @throws IOException if an I/O error occurs during the recognition process
     * @throws InterruptedException if the recognition process is interrupted
     */
    public void startRecognition(PredictionListenerInterface listener) throws IOException, InterruptedException {
        scriptRunner.startRecognition(listener);
    }
}
