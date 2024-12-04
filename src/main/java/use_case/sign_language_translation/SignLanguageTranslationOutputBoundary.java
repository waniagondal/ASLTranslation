package use_case.sign_language_translation;

/**
 * The output boundary for the sign language translation use case.
 */
public interface SignLanguageTranslationOutputBoundary {
    /**
     * Prepares the success view for the sign language translation use case.
     * @param signLanguageTranslationOutputData the output data
     */
    void prepareSuccessView(SignLanguageTranslationOutputData signLanguageTranslationOutputData);
}
