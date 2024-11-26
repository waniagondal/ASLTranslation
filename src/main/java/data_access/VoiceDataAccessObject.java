package data_access;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;

public class VoiceDataAccessObject implements CustomizeVoiceDataAccessInterface {
    private AudioSettings settings = new AudioSettingsFactory().create(1.5, 2.0,
                                                                false, 6.0);

    @Override
    public void changeSettings(AudioSettings settings) {
        this.settings = settings;
    }

    @Override
    public void setAudioSettings(AudioSettings settings) {
        this.settings = settings;
    }

    @Override
    public AudioSettings getCurrentAudioSettings() {
        return settings;
    }

}
