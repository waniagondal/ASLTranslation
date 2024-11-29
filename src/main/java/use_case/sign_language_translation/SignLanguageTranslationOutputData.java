package use_case.sign_language_translation;

/**
 * A data container class for the result of a sign language signLanguageTranslationDisplay.
 * It holds the translated text and information about the success or failure of the signLanguageTranslationDisplay.
 */
public class SignLanguageTranslationOutputData {

    private final String translatedText;

    /**
     * Constructor to initialize the output data with translated text and signLanguageTranslationDisplay status.
     *
     * @param translatedText The translated text.
     */
    public SignLanguageTranslationOutputData(String translatedText) {
        this.translatedText = translatedText;
    }

    /**
     * Gets the translated text.
     *
     * @return The translated text.
     */
    public String getTranslatedText() {
        return translatedText;
    }
}

