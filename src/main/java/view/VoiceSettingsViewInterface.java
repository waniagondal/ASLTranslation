package view;

import entity.AudioSettings;

public interface VoiceSettingsViewInterface {

    /**
     * Update the text to speech audio settings to the user-customized settings
     * @param settings the audio settings data to be set
     */
    void setAudioSettings(AudioSettings settings);
}
