package interface_adapters;

import entities.AudioTranscription;

public interface SpeechInputBoundary {
    AudioTranscription processSpeech(byte[] audioData) throws Exception;
}
