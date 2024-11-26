package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a signLanguageTranslationDisplay entity, encapsulating the original text,
 * the target language, and a history of translations.
 */
public class Translation {

    private final String text; // Original transcription or input text
    private String targetLanguage; // Target language for signLanguageTranslationDisplay

    /**
     * Constructs a new Translation object.
     *
     * @param text the original text or transcription
     * @param targetLanguage the target language for signLanguageTranslationDisplay
     */
    public Translation(String text, String targetLanguage, List<String> translationHistory) {
        this.text = text;
        this.targetLanguage = targetLanguage;
    }

    /**
     * Returns the target language for this signLanguageTranslationDisplay.
     *
     * @return the target language
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * Updates the target language for the signLanguageTranslationDisplay.
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
}

