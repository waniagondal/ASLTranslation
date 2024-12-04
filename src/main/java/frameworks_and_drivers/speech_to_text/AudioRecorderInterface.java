<<<<<<<< HEAD:src/main/java/interface_adapter/speech_to_text/AudioRecorderInterface.java
package interface_adapter.speech_to_text;
========
package frameworks_and_drivers.speech_to_text;
>>>>>>>> fb3c40eb96d7190a1713356a13b66e0a5de66b3d:src/main/java/frameworks_and_drivers/speech_to_text/AudioRecorder.java

/**
 * Interface for audio recording functionality.
 * Classes implementing this interface should handle audio recording,
 * including starting, stopping, and providing the recorded audio data.
 */
public interface AudioRecorderInterface {
    /**
     * Starts recording audio.
     */

    void start();
    /**
     * Stops recording audio.
     */

    void stop();

    /**
     * Retrieves the recorded audio data.
     *
     * @return A byte array containing the recorded audio data.
     */
    byte[] getAudioData();
}