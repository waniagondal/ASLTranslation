package interface_adapter.customize_voice;

import use_case.customize_voice.CustomizeVoiceInputBoundary;
import use_case.customize_voice.CustomizeVoiceInputData;

/**
 * The controller for the Customize Voice Use Case.
 */
public class CustomizeVoiceController {

    private final CustomizeVoiceInputBoundary customizeVoiceInteractor;

    public CustomizeVoiceController(CustomizeVoiceInputBoundary customizeVoiceInteractor) {
        this.customizeVoiceInteractor = customizeVoiceInteractor;
    }

    /**
     * Executes the Customize Voice Use Case.
     *
     * @param speed     the speed of the audio.
     * @param voiceType the type of voice (true for male, false for female).
     * @param pitch     the pitch of the audio.
     */
    public void execute(double speed, Boolean voiceType, double pitch) {
        final CustomizeVoiceInputData customizeVoiceInputData = new CustomizeVoiceInputData(speed, voiceType, pitch);

        customizeVoiceInteractor.execute(customizeVoiceInputData);
    }
}
