package use_case.sign_language_translation;

/**
 * The output boundary for the select_language usecase.
 */
public interface SignLanguageTranslationOutputBoundary {
    /**
     * Prepares the success view for the select_language usecase.
     * @param signLanguageTranslationOutputData the output data
     */
    void prepareSuccessView(SignLanguageTranslationOutputData signLanguageTranslationOutputData);

    /**
     * Prepares the failed view for the select_language usecase.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
