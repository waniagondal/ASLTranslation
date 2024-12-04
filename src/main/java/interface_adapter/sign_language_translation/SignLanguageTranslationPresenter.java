package interface_adapter.sign_language_translation;

import interface_adapter.ViewInterface;
import use_case.sign_language_translation.SignLanguageTranslationOutputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationOutputData;

/**
 * Presenter for handling the presentation logic of the sign language signLanguageTranslationDisplay use case.
 */
public class SignLanguageTranslationPresenter implements SignLanguageTranslationOutputBoundary {

    private final ViewInterface view;

    /**
     * Constructor for the TranslationPresenter.
     *
     * @param view the view that will display the signLanguageTranslationDisplay results
     */
    public SignLanguageTranslationPresenter(ViewInterface view) {
        this.view = view;
    }

    /**
     * Prepare and present the success view for signLanguageTranslationDisplay results.
     * Updates the SignLanguageView with the translated text.
     *
     * @param outputData the data containing the signLanguageTranslationDisplay result
     */
    @Override
    public void prepareSuccessView(SignLanguageTranslationOutputData outputData) {
        final String translatedText = outputData.getTranslatedText();
        view.signLanguageTranslationDisplay(translatedText);
    }
}

