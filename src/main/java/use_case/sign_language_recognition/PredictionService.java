package use_case.sign_language_recognition;

import frameworks_and_drivers.sign_language_recognition.PythonScriptRunner;
import interface_adapter.sign_language_recognition.PredictionInterface;

import java.io.IOException;

/**
 * Service for managing predictions using the PythonScriptRunner.
 */
public class PredictionService implements PredictionInterface {
    private final PythonScriptRunner scriptRunner;

    public PredictionService(String pythonInterpreter, String scriptPath) {
        this.scriptRunner = new PythonScriptRunner(pythonInterpreter, scriptPath);
    }

    @Override
    public void startRecognition(PythonScriptRunner.PredictionListener listener) throws IOException, InterruptedException {
        scriptRunner.runScriptContinuous(listener);
    }
}
