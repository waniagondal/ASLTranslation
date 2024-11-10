package frameworks_and_drivers;

import java.io.IOException;

public class RunSignLanguageApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        String pythonInterpreter = "python3";
        String scriptPath = "src/main/python/hand_gesture_recognition.py";

        PythonScriptRunner scriptRunner = new PythonScriptRunner(pythonInterpreter, scriptPath);
        String output = scriptRunner.runScript();
        System.out.println("Python script output: \n" + output);
    }
}