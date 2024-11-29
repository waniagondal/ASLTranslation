package use_case.customize_voice;

/**
 * The Input Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceInputData {

    private double speed;
    private Boolean voiceType;
    private double pitch;

    public CustomizeVoiceInputData(double speed, boolean voiceType, double pitch) {
        this.speed = speed;
        this.voiceType = voiceType;
        this.pitch = pitch;
    }

    public double getSpeed() {
        return speed;
    }

    public Boolean getVoiceType() {
        return voiceType;
    }

    public double getPitch() {
        return pitch;
    }
}
