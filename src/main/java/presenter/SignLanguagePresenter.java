package presenter;

import interface_adapter.PredictionInterface;
import view.SignLanguageView;

import java.io.IOException;

public class SignLanguagePresenter {
    private final SignLanguageView view;
    private final PredictionInterface predictor;

    public SignLanguagePresenter(SignLanguageView view, PredictionInterface predictor) {
        this.view = view;
        this.predictor = predictor;
    }

    public void startRecognition() throws IOException, InterruptedException {
        predictor.startRecognition(this::updateViewWithPrediction);
    }

    private void updateViewWithPrediction(String prediction) {
        view.updateDisplay(prediction);
    }
}
