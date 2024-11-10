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

    public String runScript() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(pythonInterpreter, scriptPath);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString();
    }
}