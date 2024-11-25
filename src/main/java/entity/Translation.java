package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a translation entity, encapsulating the original text,
 * the target language, and a history of translations.
 */
public class Translation {

    private final String text; // Original transcription or input text
    private String targetLanguage; // Target language for translation
    private final List<String> translationHistory; // History of translations

    /**
     * Constructs a new Translation object.
     *
     * @param text the original text or transcription
     * @param targetLanguage the target language for translation
     * @param translationHistory the history of translations
     */
    public Translation(String text, String targetLanguage, List<String> translationHistory) {
        this.text = text;
        this.targetLanguage = targetLanguage;
        this.translationHistory = new ArrayList<>(translationHistory);
    }

    /**
     * Returns an unmodifiable view of the translation history.
     *
     * @return an unmodifiable list of translation history
     */
    public List<String> getTranslationHistory() {
        return Collections.unmodifiableList(translationHistory);
    }

    /**
     * Returns the target language for this translation.
     *
     * @return the target language
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * Updates the target language for the translation.
     *
     * @param targetLanguage the new target language
     */
    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    /**
     * Returns the original text.
     *
     * @return the original text
     */
    public String getText() {
        return text;
    }

    /**
     * Adds a new translation to the history.
     *
     * @param translation the new translation to add
     */
    public void addTranslationToHistory(String translation) {
        translationHistory.add(translation);
    }
}

