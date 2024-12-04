package interface_adapter.sign_language_recognition;

import java.io.IOException;

/**
 * Interface for handling prediction operations.
 */
public interface PredictionInterface {

    /**
     * Starts the sign language recognition process.
     *
     * @param listener the PredictionListenerInterface implementation that handles prediction results
     * @throws IOException if an I/O error occurs during the recognition process
     * @throws InterruptedException if the recognition process is interrupted
     */
    void startRecognition(PredictionListenerInterface listener) throws IOException, InterruptedException;
}
