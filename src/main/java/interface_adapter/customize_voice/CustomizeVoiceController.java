package interface_adapter.customize_voice;

import use_case.customize_voice.CustomizeVoiceInputBoundary;
import use_case.customize_voice.CustomizeVoiceInputData;

public class CustomizeVoiceController {
    private final CustomizeVoiceInputBoundary customizeVoiceInputBoundary;

    public CustomizeVoiceController(CustomizeVoiceInputBoundary customizeVoiceInputBoundary) {
        this.customizeVoiceInputBoundary = customizeVoiceInputBoundary;
    }

    public void execute(double voiceSpeed, double voiceVolume, Boolean voiceType, double voicePitch) {
        final CustomizeVoiceInputData customizeVoiceInputData = new CustomizeVoiceInputData(voiceSpeed, voiceVolume,
                voiceType, voicePitch);

        customizeVoiceInputBoundary.execute(customizeVoiceInputData);
    }
}
