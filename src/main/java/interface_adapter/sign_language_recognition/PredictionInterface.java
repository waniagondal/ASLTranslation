package interface_adapter.sign_language_recognition;

import frameworks_and_drivers.sign_language_recognition.PythonScriptRunner;

import java.io.IOException;

/**
 * Interface for handling prediction operations.
 */
public interface PredictionInterface {

    /**
     * Starts the recognition process.
     *
     * @param listener the listener to handle each prediction
     * @throws IOException          if there is an I/O error
     * @throws InterruptedException if the process is interrupted
     */
    void startRecognition(PythonScriptRunner.PredictionListener listener) throws IOException, InterruptedException;
}