package use_case.customize_voice;

import entity.AudioSettings;

/**
 * Output Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceOutputData {

    private final AudioSettings settings;

    public CustomizeVoiceOutputData(AudioSettings settings) {
        this.settings = settings;
    }

    public AudioSettings getAudioSettings() {
        return settings;
    }

}
