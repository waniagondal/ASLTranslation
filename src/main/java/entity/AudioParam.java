package entity;

public class AudioParam {
    private final double speed;
    private final double volume;
    private final Boolean voiceType;
    private final double pitch;

    public AudioParam(double speed, double volume, Boolean voiceType, double pitch) {
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
