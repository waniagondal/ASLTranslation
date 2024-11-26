package use_case.sign_language_translation;

/**
 * Input boundaries for actions related to select_language.
 */
public interface SignLanguageTranslationInputBoundary {

    /**
     * Executed the select_language use-case.
     * @param signLanguageTranslationInputData the input data
     */
    void execute(SignLanguageTranslationInputData signLanguageTranslationInputData);

}
