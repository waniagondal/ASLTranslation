package frameworks_and_drivers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PythonScriptRunner {
    private final String pythonInterpreter;
    private final String scriptPath;

    public PythonScriptRunner(String pythonInterpreter, String scriptPath) {
        this.pythonInterpreter = pythonInterpreter;
        this.scriptPath = scriptPath;
    }

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
        void onPrediction(String prediction);
    }
}
