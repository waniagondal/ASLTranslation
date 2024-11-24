package use_case.text2speech;

import entity.AudioParam;

/**
 * The input data for the Text to Speech Use Case.
 */
public class Text2SpeechInputData {
    private final String text;
    private final String languagecode;
    private final boolean gender;
    private final double speakingRate;
    private final double volume;
    private final double pitch;


    public Text2SpeechInputData(String text, String languageCode, AudioParam audioparam ) {
        this.text = text;
        this.languagecode = languageCode;
        this.gender = audioparam.getVoiceType();
        this.speakingRate = audioparam.getSpeed();
        this.volume = audioparam.getVolume();
        this.pitch = audioparam.getPitch();
    }

    public String getText() {
        return text;
    }

    public String getLanguageCode() {
        return languagecode;
    }

    public boolean getGender() {
        return gender;
    }

    public double getSpeakingRate() {
        return speakingRate;
    }

    public double getVolume() {
        return volume;
    }

    public double getPitch() {
        return pitch;
    }
}
