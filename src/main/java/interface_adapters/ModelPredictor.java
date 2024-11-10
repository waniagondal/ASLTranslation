package interface_adapters;

import entity.Gesture;
import frameworks_and_drivers.ModelService;

public class ModelPredictor implements ModelInterface {

    private ModelService modelService;

    public ModelPredictor(ModelService modelService) {

        this.modelService = modelService;
    }

    @Override
    public String predict(Gesture gesture) {
        float[] modelInput = InputPreprocessor.preprocess(gesture.getGestureCoordinates());
        float[] rawOutput = modelService.predict(modelInput);
        return OutputPostprocessor.postprocess(rawOutput);
    }

    public Translation getPredictionTranslation(Gesture gesture, String targetLanguage) {
        String predictionText = predict(gesture);
        List<String> translationHistory = new ArrayList<>();
        translationHistory.add(predictionText);

        return new Translation(predictionText, targetLanguage, translationHistory);
    }
}