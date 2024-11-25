package interface_adapter.sign_language_translation;

import use_case.sign_language_translation.SignLanguageTranslationOutputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationOutputData;
import view.SignLanguageView;

/**
 * Presenter for handling the presentation logic of the sign language translation use case.
 * Implements the Output Boundary to receive and process the translation results.
 */
public class SignLanguageTranslationPresenter implements SignLanguageTranslationOutputBoundary {

    private final SignLanguageView view;

    /**
     * Constructor for the TranslationPresenter.
     *
     * @param view the view that will display the translation results
     */
    public SignLanguageTranslationPresenter(SignLanguageView view) {
        this.view = view;
    }

    /**
     * Prepare and present the success view for translation results.
     * Updates the SignLanguageView with the translated text.
     *
     * @param outputData the data containing the translation result
     */
    @Override
    public void prepareSuccessView(SignLanguageTranslationOutputData outputData) {
        String translatedText = outputData.getTranslatedText();
        view.updateDisplay(translatedText);
    }

    /**
     * Prepare and present the failure view in case of an error during translation.
     * Updates the SignLanguageView with an error message.
     *
     * @param error the error message to display
     */
    @Override
    public void prepareFailView(String error) {
        view.updateDisplay("Error: " + error);
    }
}

