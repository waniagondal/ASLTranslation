package interface_adapters;

public interface SpeechRecognizer {
    String recognize(byte[] audioData) throws Exception;
}
