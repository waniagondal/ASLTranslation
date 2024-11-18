package use_case.customize_voice;

public class CustomizeVoiceInputData {
    private final double voiceSpeed;
    private final double voiceVolume;
    private final Boolean voiceType;
    private final double voicePitch;

    public CustomizeVoiceInputData(double voiceSpeed, double voiceVolume, Boolean voiceType, double voicePitch) {
        this.voiceSpeed = voiceSpeed;
        this.voiceVolume = voiceVolume;
        this.voiceType = voiceType;
        this.voicePitch = voicePitch;
    }

    public double getVoiceSpeed() {
        return voiceSpeed;
    }

    public double getVoiceVolume() {
        return voiceVolume;
    }

    public Boolean getVoiceType() {
        return voiceType;
    }

    public double getVoicePitch() {
        return voicePitch;
    }
}
