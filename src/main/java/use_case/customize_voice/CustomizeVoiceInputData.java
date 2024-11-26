package use_case.customize_voice;

/**
 * The Input Data for the Customize Voice Use Case.
 */
public class CustomizeVoiceInputData {

    private double speed;
    private double volume;
    private Boolean voiceType;
    private double pitch;

    public CustomizeVoiceInputData(double speed, double volume, boolean voiceType, double pitch) {
        this.speed = speed;
        this.volume = volume;
        this.voiceType = voiceType;
        this.pitch = pitch;
    }

    public double getSpeed() {
        return speed;
    }

    public double getVolume() {
        return volume;
    }

    public Boolean getVoiceType() {
        return voiceType;
    }

    public double getPitch() {
        return pitch;
    }
}
