package frameworks_and_drivers.sign_language_recognition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interface_adapter.sign_language_recognition.PredictionInterface;
import interface_adapter.sign_language_recognition.PredictionListenerInterface;

/**
 * Utility for running a Python script to process continuous input and emit predictions.
 */
public class PythonScriptRunner implements PredictionInterface {
    private final String pythonInterpreter;
    private final String scriptPath;

    public PythonScriptRunner(String pythonInterpreter, String scriptPath) {
        this.pythonInterpreter = pythonInterpreter;
        this.scriptPath = scriptPath;
    }

    /**
     * Runs the Python script continuously and triggers the listener with predictions.
     *
     * @param listener the callback for each line of output (prediction)
     * @throws IOException if there is an error with I/O operations
     * @throws InterruptedException if the thread is interrupted
     */
    @Override
    public void startRecognition(PredictionListenerInterface listener) throws IOException, InterruptedException {
        final ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, scriptPath);
        processBuilder.redirectErrorStream(false);
        final Process process = processBuilder.start();

        final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            listener.onPrediction(line);
        }

        process.waitFor();
    }
}
