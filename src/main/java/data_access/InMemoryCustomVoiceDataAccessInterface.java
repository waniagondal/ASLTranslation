package data_access;

import entity.AudioParam;

public class InMemoryCustomVoiceDataAccessInterface implements CustomizeVoiceDataAccessInterface{
    private AudioParam audioParam = new AudioParam(1, 1, false, 1);

    @Override
    public void changeParam(AudioParam audioParam) {
        this.audioParam = new AudioParam(audioParam.getSpeed(), audioParam.getVolume(), audioParam.getVoiceType(),
                audioParam.getPitch());
    }

    @Override
    public AudioParam get() {
        return audioParam;
    }
}
