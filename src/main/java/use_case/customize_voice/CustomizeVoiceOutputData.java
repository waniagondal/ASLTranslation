package use_case.customize_voice;

/**
 * Output Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceOutputData {

    private final boolean useCaseFailed;

    public CustomizeVoiceOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
