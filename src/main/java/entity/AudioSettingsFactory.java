package entity;

/**
 * A factory class for creating AudioSettings objects.
 */
public class AudioSettingsFactory {

    /**
         * Creates a new AudioSettings object with the specified values.
     *
     * @param speed the speed of the audio.
     * @param volume the volume of the audio.
     * @param voiceType the type of voice (true for male, false for female).
     * @param pitch the pitch of the audio.
     * @return a new AudioParam object.
     */
    public AudioSettings create(double speed, double volume, Boolean voiceType, double pitch) {
        return new AudioSettings(speed, volume, voiceType, pitch);
    }
}