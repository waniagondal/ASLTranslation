//package frameworks_and_drivers;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class PythonScriptRunner {
//    private final String pythonInterpreter;
//    private final String scriptPath;
//
//    public PythonScriptRunner(String pythonInterpreter, String scriptPath) {
//        this.pythonInterpreter = pythonInterpreter;
//        this.scriptPath = scriptPath;
//    }
//
//    public void runScriptContinuous(PredictionListener listener) throws IOException, InterruptedException {
//        ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, scriptPath);
//        processBuilder.redirectErrorStream(false);
//        Process process = processBuilder.start();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            listener.onPrediction(line);  // Trigger the listener for each new letter
//        }
//
//        process.waitFor();
//    }
//
//    public interface PredictionListener {
//        void onPrediction(String prediction);
//    }
//}

package frameworks_and_drivers.sign_language_recognition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Utility for running a Python script to process continuous input and emit predictions.
 */
public class PythonScriptRunner {
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
    public void runScriptContinuous(PredictionListener listener) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, scriptPath);
        processBuilder.redirectErrorStream(false);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            listener.onPrediction(line);  // Trigger the listener for each new letter
        }

        process.waitFor();
    }

    public interface PredictionListener {
        void onPrediction(String prediction) throws IOException, InterruptedException;
    }
}
