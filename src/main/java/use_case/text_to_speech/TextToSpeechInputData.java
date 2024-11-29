package use_case.text_to_speech;

import entity.AudioSettings;

/**
 * The input data for the Text to Speech Use Case.
 * This class contains all necessary settings to convert text into speech.
 */
public class TextToSpeechInputData {

    private final String text;
    private final String languageCode;
    private final boolean gender;
    private final double speakingRate;
    private final double pitch;


    /**
     * Constructs a TextToSpeechInputData instance using the provided text, language code, and audio settings.
     *
     * @param text The text to be converted to speech.
     * @param languageCode The language code for speech synthesis (e.g., "en-US").
     * @param audioSettings The audio settings containing voice type, speaking rate, volume, and pitch.
     */
    public TextToSpeechInputData(String text, String languageCode, AudioSettings audioSettings ) {
        this.text = text;
        this.languageCode = languageCode;
        this.gender = audioSettings.getVoiceType();
        this.speakingRate = audioSettings.getSpeed();
        this.pitch = audioSettings.getPitch();
    }

    /**
     * Gets the text to be converted to speech.
     *
     * @return The text for speech synthesis.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the language code for speech synthesis.
     *
     * @return The language code (e.g., "en-US").
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Gets the gender of the voice for speech synthesis.
     *
     * @return true if the voice is male, false if female.
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * Gets the speaking rate for speech synthesis.
     *
     * @return The speaking rate as a double (e.g., 1.0 for normal speed).
     */
    public double getSpeakingRate() {
        return speakingRate;
    }

    /**
     * Gets the pitch for speech synthesis.
     *
     * @return The pitch level as a double.
     */
    public double getPitch() {
        return pitch;
    }
}
