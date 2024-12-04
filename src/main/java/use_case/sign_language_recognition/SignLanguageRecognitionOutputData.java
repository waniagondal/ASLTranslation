package use_case.sign_language_recognition;

/**
 * This class holds the output data that is passed from the use case
 * to the presenter. It contains the results of the recognition process.
 */
public class SignLanguageRecognitionOutputData {

    private final String prediction;

    /**
     * Constructor to create the output data for the prediction result.
     *
     * @param prediction the prediction result from the recognition process
     */
    public SignLanguageRecognitionOutputData(String prediction) {
        this.prediction = prediction;
    }

    /**
     * Getter for the prediction result.
     *
     * @return the predicted sign language gesture (e.g., a letter or symbol)
     */
    public String getPrediction() {
        return prediction;
    }
}
