package use_case.sign_language_translation;

/**
 * A data container class for the result of a sign language signLanguageTranslationDisplay.
 * It holds the translated text and information about the success or failure of the signLanguageTranslationDisplay.
 */
public class SignLanguageTranslationOutputData {

    private final String translatedText;
    private final boolean useCaseFailed;

    /**
     * Constructor to initialize the output data with translated text and signLanguageTranslationDisplay status.
     *
     * @param translatedText The translated text.
     * @param useCaseFailed The status of the signLanguageTranslationDisplay (e.g., success or failure).
     */
    public SignLanguageTranslationOutputData(String translatedText, boolean useCaseFailed) {
        this.translatedText = translatedText;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the translated text.
     *
     * @return The translated text.
     */
    public String getTranslatedText() {
        return translatedText;
    }

    /**
     * Gets the signLanguageTranslationDisplay status.
     *
     * @return The status of the signLanguageTranslationDisplay.
     */
    public boolean useCaseFailed() {
        return useCaseFailed;
    }

}
