package interface_adapters;


public interface AudioRecorder {
    void start();
    void stop();
    byte[] getAudioData();
}
