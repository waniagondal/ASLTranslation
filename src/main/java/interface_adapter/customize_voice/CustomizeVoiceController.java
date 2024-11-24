package interface_adapter.customize_voice;

import use_case.customize_voice.CustomizeVoiceInputBoundary;
import use_case.customize_voice.CustomizeVoiceInputData;

public class CustomizeVoiceController {
    private final CustomizeVoiceInputBoundary customizeVoiceInteractor;

    public CustomizeVoiceController(CustomizeVoiceInputBoundary customizeVoiceInputBoundary) {
        this.customizeVoiceInteractor = customizeVoiceInputBoundary;
    }

    public void execute(double voiceSpeed, double voiceVolume, Boolean voiceType, double voicePitch) {
        final CustomizeVoiceInputData customizeVoiceInputData = new CustomizeVoiceInputData(voiceSpeed, voiceVolume,
                voiceType, voicePitch);

        customizeVoiceInteractor.execute(customizeVoiceInputData);
    }
}
