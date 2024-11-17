package entities;

public class AudioTranscription {
    private final String text;

    public AudioTranscription(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}