package interface_adapter.sign_language_translation;

import use_case.sign_language_translation.SignLanguageTranslationInputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationInputData;

/**
 * The controller for the select language use case.
 */
public class SignLanguageTranslationController {

    private final SignLanguageTranslationInputBoundary signLanguageInteractor;

    public SignLanguageTranslationController(SignLanguageTranslationInputBoundary selectLanguageInteractor) {
        this.signLanguageInteractor = selectLanguageInteractor;
    }

    /**
     * Executes the select language use case
     */
    public void execute(String language, String text) {
        final SignLanguageTranslationInputData signLanguageTranslationInputData = new SignLanguageTranslationInputData(language, text);
        signLanguageInteractor.execute(signLanguageTranslationInputData);
    }
}
