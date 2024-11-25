package interface_adapter.sign_language_translation;

/**
 * Data Access Interface for the Sign Language Translation use case.
 * Defines the contract for accessing translation-related data and services.
 */
public interface SignLanguageTranslationDataAccessInterface {

    /**
     * Translates the given text into the specified language.
     * This method focuses on the translation functionality only,
     * with user preferences and default settings handled in other use cases.
     *
     * @param language the target language for the translation
     * @param text     the text to be translated
     * @return the translated version of the text
     */
    String translate(String language, String text);
}
