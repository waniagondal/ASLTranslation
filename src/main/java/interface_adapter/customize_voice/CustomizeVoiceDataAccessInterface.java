package interface_adapter.customize_voice;

import entity.AudioSettings;

public interface CustomizeVoiceDataAccessInterface {

    /**
     * Changes the audio settings to the given ones.
     * @param settings the audio settings to save
     */
    void changeSettings(AudioSettings settings);

    /**
     * Sets the given audio settings as a state.
     * @param settings the audio settings to set
     */
    void setAudioSettings(AudioSettings settings);

    /**
     * Gets the current audio settings.
     * @return current audio settings
     */
    AudioSettings getCurrentAudioSettings();
}
