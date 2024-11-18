package entity;

public class AudioParamFactory {

    public AudioParam create(double speed, double volume, Boolean voiceType, double pitch) {
        return new AudioParam(speed, volume, voiceType, pitch);
    }
}
