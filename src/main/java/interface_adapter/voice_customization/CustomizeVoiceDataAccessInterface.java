package interface_adapter.voice_customization;

import entity.AudioSettings;

/**
 * The interface of the DAO for the Customize Voice Use Case.
 */
public interface CustomizeVoiceDataAccessInterface {

    /**
     * Updates the system to change the audio parameters.
     * @param audioSettings the audio parameters to be updated
     */
    void changeParam(AudioSettings audioSettings);
}
