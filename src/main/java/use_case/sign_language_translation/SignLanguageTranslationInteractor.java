package use_case.sign_language_translation;

import interface_adapter.sign_language_translation.SignLanguageTranslationDataAccessInterface;

/**
 * The interactor responsible for handling the logic of sign language signLanguageTranslationDisplay.
 * This class processes the signLanguageTranslationDisplay request and communicates with the data access object and the presenter.
 */
public class SignLanguageTranslationInteractor implements SignLanguageTranslationInputBoundary {

    private final SignLanguageTranslationDataAccessInterface languageDataAccessObject;
    private final SignLanguageTranslationOutputBoundary signLanguageTranslationPresenter;

    /**
     * Constructor to initialize the interactor with necessary dependencies.
     *
     * @param languageDataAccessObject the data access object used to translate text
     * @param signLanguageTranslationOutputBoundary the presenter responsible for displaying the result
     */
    public SignLanguageTranslationInteractor(SignLanguageTranslationDataAccessInterface languageDataAccessObject,
                                             SignLanguageTranslationOutputBoundary signLanguageTranslationOutputBoundary) {
        this.languageDataAccessObject = languageDataAccessObject;
        this.signLanguageTranslationPresenter = signLanguageTranslationOutputBoundary;
    }

    /**
     * Executes the signLanguageTranslationDisplay logic by taking in user input, translating the text,
     * and sending the result to the presenter.
     *
     * @param signLanguageTranslationInputData the input data containing the language and text to be translated
     */
    @Override
    public void execute(SignLanguageTranslationInputData signLanguageTranslationInputData) {
        // Retrieve the language and text to translate from the input data
        final String language = signLanguageTranslationInputData.getLanguage();
        final String text = signLanguageTranslationInputData.getText();

        // Perform the signLanguageTranslationDisplay using the data access object (DAO)
        String translatedText = languageDataAccessObject.translate(language, text);

        // Prepare the output data with the translated text
        SignLanguageTranslationOutputData signLanguageTranslationOutputData =
                new SignLanguageTranslationOutputData(translatedText, false);

        // Pass the translated output data to the presenter to update the view
        signLanguageTranslationPresenter.prepareSuccessView(signLanguageTranslationOutputData);
    }
}
