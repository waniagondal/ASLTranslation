package interface_adapter;

import frameworks_and_drivers.PythonScriptRunner;

import java.io.IOException;

public interface PredictionInterface {

    void startRecognition(PythonScriptRunner.PredictionListener listener) throws IOException, InterruptedException;
}