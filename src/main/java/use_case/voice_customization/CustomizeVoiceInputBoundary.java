package use_case.voice_customization;

/**
 * The Customize Voice Use Case.
 */
public interface CustomizeVoiceInputBoundary {

    /**
     * Execute the Customize Voice Use Case.
     * @param customizeVoiceInputData the input data for this use case
     */
    void execute(CustomizeVoiceInputData customizeVoiceInputData);
}
