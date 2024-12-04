package interface_adapter.sign_language_translation;

import use_case.sign_language_translation.SignLanguageTranslationInputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationInputData;

/**
 * The controller for the select language use case.
 */
public class SignLanguageTranslationController {

    private final SignLanguageTranslationInputBoundary signLanguageInteractor;

    /**
     * Constructs a SignLanguageTranslationController with the specified use case interactor.
     *
     * @param signLanguageInteractor the use case boundary responsible for handling sign language translation logic.
     */
    public SignLanguageTranslationController(SignLanguageTranslationInputBoundary signLanguageInteractor) {
        this.signLanguageInteractor = signLanguageInteractor;
    }

    /**
     * Executes the select language use case.
     * @param language the language to which the sign language should be translated.
     * @param text the text to be translated into sign language.
     */
    public void execute(String language, String text) {
        final SignLanguageTranslationInputData signLanguageTranslationInputData = new SignLanguageTranslationInputData(
                language, text);
        signLanguageInteractor.execute(signLanguageTranslationInputData);
    }
}
