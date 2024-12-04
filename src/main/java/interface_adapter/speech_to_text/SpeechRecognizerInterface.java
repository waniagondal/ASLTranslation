package interface_adapter.speech_to_text;

/**
 * Interface for speech recognition functionality.
 * Classes implementing this interface should handle converting
 * audio data into text using a speech recognition system.
 */
public interface SpeechRecognizerInterface {

    /**
     * Recognizes speech from the given audio data.
     *
     * @param audioData The audio data in byte array format.
     * @return A String containing the transcribed text.
     * @throws Exception If an error occurs during the recognition process.
     */
    String recognize(byte[] audioData) throws Exception;
}
