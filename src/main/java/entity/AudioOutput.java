package entity;
public class AudioOutput {
    private final String text;
    private final String audioFormat;
    private final String language;

    AudioOutput (String text, String audioFormat, String language) {
        this.text = text;
        this.audioFormat = audioFormat;
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public String getAudioFormat() {
        return audioFormat;
    }

    public String getLanguage() {
        return language;
    }
}
