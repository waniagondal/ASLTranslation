package entity;

import java.util.List;

public class Translation {
    private final String text;
    private final String targetLanguage;
    private final List<String> translationHistory;

    Translation (String text, String targetLanguage, List<String> translationHistory) {
        this.text = text;
        this.targetLanguage = targetLanguage;
        this.translationHistory = translationHistory;
    }

    public List<String> getTranslationHistory() {
        return translationHistory;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public String getText() {
        return text;
    }
}
