package interface_adapter.Speech2Text;

import entity.AudioTranscription;
/**
 * Interface defining the input boundary for the speech processing use case.
 * Classes implementing this interface should handle the processing of
 * speech input and return the corresponding transcription.
 */
public interface SpeechInputBoundary {

    /**
     * Processes the given audio data and returns the transcription.
     *
     * @param audioData The audio data in byte array format.
     * @return An {@link AudioTranscription} object containing the transcribed text.
     * @throws Exception If an error occurs during speech processing.
     */
    AudioTranscription processSpeech(byte[] audioData) throws Exception;
}
