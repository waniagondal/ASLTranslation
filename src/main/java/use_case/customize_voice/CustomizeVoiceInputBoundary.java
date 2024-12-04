package use_case.customize_voice;

/**
 * Input Boundary for TTS voice customization.
 */
public interface CustomizeVoiceInputBoundary {

    /**
     * Executes the customize voice use case.
     * @param customizeVoiceInputData the input data
     */
    void execute(CustomizeVoiceInputData customizeVoiceInputData);
}
