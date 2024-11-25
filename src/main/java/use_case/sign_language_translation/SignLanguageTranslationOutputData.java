package use_case.sign_language_translation;

/**
 * A data container class for the result of a sign language translation.
 * It holds the translated text and information about the success or failure of the translation.
 */
public class SignLanguageTranslationOutputData {

    private final String translatedText;
    private final boolean useCaseFailed;

    /**
     * Constructor to initialize the output data with translated text and translation status.
     *
     * @param translatedText The translated text.
     * @param useCaseFailed The status of the translation (e.g., success or failure).
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
     * Gets the translation status.
     *
     * @return The status of the translation.
     */
    public boolean useCaseFailed() {
        return useCaseFailed;
    }

}
