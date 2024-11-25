package use_case.sign_language_translation;

/**
 * Input Data for the Sign Language Translation Use Case.
 * This class encapsulates the input parameters required to perform a sign language translation,
 * including the target language and the text to be translated.
 */
public class SignLanguageTranslationInputData {

    private final String language;
    private final String text;

    /**
     * Constructor to initialize the input data with the target language and the text to be translated.
     *
     * @param language The language to which the text should be translated.
     * @param signTranslation The text that needs to be translated (in sign language).
     */
    public SignLanguageTranslationInputData(String language, String signTranslation) {
        this.language = language;
        this.text = signTranslation;
    }

    /**
     * Gets the target language for translation.
     *
     * @return The target language for the translation.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the text to be translated.
     *
     * @return The text to be translated.
     */
    public String getText() {
        return text;
    }
}
