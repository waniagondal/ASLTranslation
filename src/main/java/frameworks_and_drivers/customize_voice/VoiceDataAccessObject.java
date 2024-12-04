package frameworks_and_drivers.customize_voice;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;

/**
 * Data access object for managing audio settings in the application.
 * This class implements the CustomizeVoiceDataAccessInterface to allow changing,
 * setting, and retrieving the audio settings used by the text-to-speech system.
 */
public class VoiceDataAccessObject implements CustomizeVoiceDataAccessInterface {

    // Constants for the default audio settings values
    private static final double DEFAULT_SPEED = 1.5;
    private static final boolean DEFAULT_VOICE_TYPE = true;
    private static final double DEFAULT_PITCH = 6.0;

    // Instance field to store the current audio settings
    private AudioSettings settings = new AudioSettingsFactory().create(
            DEFAULT_SPEED, DEFAULT_VOICE_TYPE, DEFAULT_PITCH);

    /**
     * Changes the current audio settings with the new settings provided.
     * This method prints the current settings before they are updated.
     *
     * @param newSettings the new audio settings to apply
     */
    @Override
    public void changeSettings(AudioSettings newSettings) {
        // Print current settings before changing
        System.out.println("Settings Before \n"
                + "Speed: " + this.settings.getSpeed()
                + "\nVoice Type: " + this.settings.getVoiceType()
                + "\nPitch: " + this.settings.getPitch());

        // Update the field with the new settings
        this.settings = newSettings;
    }

    /**
     * Sets the audio settings to the specified new settings.
     *
     * @param newSettings the new audio settings to set
     */
    @Override
    public void setAudioSettings(AudioSettings newSettings) {
        // Simply set the new settings to the field
        this.settings = newSettings;
    }

    /**
     * Retrieves the current audio settings.
     *
     * @return the current audio settings
     */
    @Override
    public AudioSettings getCurrentAudioSettings() {
        return settings;
    }
}
