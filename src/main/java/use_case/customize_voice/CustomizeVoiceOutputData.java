package use_case.customize_voice;

import entity.AudioSettings;

/**
 * Output Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceOutputData {

    private final AudioSettings settings;
    private final boolean useCaseFailed;

    public CustomizeVoiceOutputData(AudioSettings settings, boolean useCaseFailed) {
        this.settings = settings;
        this.useCaseFailed = useCaseFailed;
    }

    public AudioSettings getAudioSettings() {
        return settings;
    }

}
