<<<<<<<< HEAD:src/main/java/interface_adapter/speech_to_text/SpeechRecognizerInterface.java
package interface_adapter.speech_to_text;
========
package frameworks_and_drivers.speech_to_text;
>>>>>>>> fb3c40eb96d7190a1713356a13b66e0a5de66b3d:src/main/java/frameworks_and_drivers/speech_to_text/SpeechRecognizer.java

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