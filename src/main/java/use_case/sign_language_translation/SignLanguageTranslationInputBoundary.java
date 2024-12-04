package use_case.sign_language_translation;

/**
 * Input boundary for actions related to sign language translation.
 */
public interface SignLanguageTranslationInputBoundary {

    /**
     * Executed the sign language translation use-case.
     * @param signLanguageTranslationInputData the input data
     */
    void execute(SignLanguageTranslationInputData signLanguageTranslationInputData);

}
