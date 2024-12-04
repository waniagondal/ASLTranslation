package interface_adapter.customize_voice;

import entity.AudioSettings;

/**
 * Interface for updating and managing the view associated with voice settings customization.
 * This interface defines methods for setting user-customized audio settings in the view,
 * allowing for dynamic updates to the text-to-speech configuration based on user preferences.
 */
public interface VoiceSettingsViewInterface {

    /**
     * Update the text to speech audio settings to the user-customized settings.
     * @param settings the audio settings data to be set
     */
    void setAudioSettings(AudioSettings settings);
}
