package interface_adapters;

import java.io.IOException;

public interface PredictionInterface {

    String getPrediction() throws IOException, InterruptedException;
}
