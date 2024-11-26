package entity;

import java.util.List;

/**
 * Factory for creating Translation Objects.
 * Implements the TranslationFactory interface.
 */
public class CreateTranslationFactory implements TranslationFactory {

    /**
     * Creates a new Translation object with the specified text, target language,
     * and translation history.
     *
     * @param text the text to be translated.
     * @param targetLanguage the language into which the text will be translated.
     * @param translationHistory a list of previous translations for reference.
     * @return a new Translation instance.
     */
    @Override
    public Translation create(String text, String targetLanguage, List<String> translationHistory) {
        return new Translation(text, targetLanguage, translationHistory);
    }
}
