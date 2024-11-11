package use_case.customize_voice;

import entity.AudioParam;

/**
 * The interface of the DAO for the Customize Voice Use Case.
 */
public interface CustomizeVoiceDataAccessInterface {

    /**
     * Updates the system to change the audio parameters.
     * @param audioParam the audio parameters to be updated
     */
    void changeParam(AudioParam audioParam);
}
