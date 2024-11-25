package interface_adapter.voice_customization;

import use_case.voice_customization.CustomizeVoiceInputBoundary;
import use_case.voice_customization.CustomizeVoiceInputData;

/**
 * Controller for handling voice customization requests.
 * It orchestrates the customization process by delegating to the input boundary.
 */
public class CustomizeVoiceController {

    private final CustomizeVoiceInputBoundary inputBoundary;

    /**
     * Constructor initializes the controller with the input boundary.
     *
     * @param inputBoundary the boundary interface for customizing the voice
     */
    public CustomizeVoiceController(CustomizeVoiceInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Executes the voice customization by creating the input data and passing it to the input boundary.
     *
     * @param voiceSpeed  the desired speed of the voice
     * @param voiceVolume the desired volume of the voice
     * @param voiceType   the type of the voice (e.g., male/female)
     * @param voicePitch  the desired pitch of the voice
     */
    public void execute(double voiceSpeed, double voiceVolume, boolean voiceType, double voicePitch) {
        // Create the data object for voice customization
        CustomizeVoiceInputData inputData = new CustomizeVoiceInputData(voiceSpeed, voiceVolume, voiceType, voicePitch);

        // Delegate the execution to the input boundary
        inputBoundary.execute(inputData);
    }
}
