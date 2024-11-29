package entity;

/**
 * Represents the parameters of audio, such as speed, volume, voice type, and pitch.
 * This entity is used for audio-related configurations and analysis.
 */
public class AudioSettings {
    private final double speed;
    private final Boolean voiceType;
    private final double pitch;

    /**
     * Constructor to create an AudioSettings object with the given values.
     *
     * @param speed the speed of the audio.
     * @param voiceType the type of voice (true for male, false for female).
     * @param pitch the pitch of the audio.
     */
    public AudioSettings(double speed, Boolean voiceType, double pitch) {
        this.speed = speed;
        this.voiceType = voiceType;
        this.pitch = pitch;
    }

    public double getSpeed() {
        return speed;
    }

    public Boolean getVoiceType() {
        return voiceType;
    }

    public double getPitch() {
        return pitch;
    }
}
