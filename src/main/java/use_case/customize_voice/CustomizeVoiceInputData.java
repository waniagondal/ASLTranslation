package use_case.customize_voice;

/**
 * The Input Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceInputData {

    private double speed;
    private Boolean voiceType;
    private double pitch;

    /**
     * Constructs a @code CustomizeVoiceInputData object with the specified parameters.
     *
     * @param speed the speed of the audio. A value of 1.0 represents normal speed,
     *              values greater than 1.0 indicate faster speeds, and values less than 1.0 indicate slower speeds.
     * @param voiceType the type of voice. {@code true} for male voice, {@code false} for female voice.
     * @param pitch the pitch of the audio. A value of 1.0 represents normal pitch,
     *              values greater than 1.0 indicate higher pitch, and values less than 1.0 indicate lower pitch.
     */
    public CustomizeVoiceInputData(double speed, boolean voiceType, double pitch) {
        this.speed = speed;
        this.voiceType = voiceType;
        this.pitch = pitch;
    }

    /**
     * Retrieves the speed of the audio.
     *
     * @return the speed of the audio as a multiplier (e.g., 1.0 for normal speed).
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Retrieves the type of voice.
     *
     * @return {@code true} if the voice is male, {@code false} if the voice is female.
     */
    public Boolean getVoiceType() {
        return voiceType;
    }

    /**
     * Retrieves the pitch of the audio.
     *
     * @return the pitch of the audio as a relative value (e.g., 1.0 for normal pitch).
     */
    public double getPitch() {
        return pitch;
    }
}
