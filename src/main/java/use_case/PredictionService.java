import java.io.IOException;

public class PredictionService implements PredictionInterface {
    private final PythonScriptRunner scriptRunner;

    public PredictionService(String pythonInterpreter, String scriptPath) {
        this.scriptRunner = new PythonScriptRunner(pythonInterpreter, scriptPath);
    }

    @Override
    public String getPrediction() throws IOException, InterruptedException {
        return scriptRunner.runScript();
    }
}