package use_case;

import frameworks_and_drivers.PythonScriptRunner;
import interface_adapter.PredictionInterface;

import java.io.IOException;

public class PredictionService implements PredictionInterface {
    private final PythonScriptRunner scriptRunner;

    public PredictionService(String pythonInterpreter, String scriptPath) {
        this.scriptRunner = new PythonScriptRunner(pythonInterpreter, scriptPath);
    }

    public void startRecognition(PythonScriptRunner.PredictionListener listener) throws IOException, InterruptedException {
        scriptRunner.runScriptContinuous(listener);
    }
}

