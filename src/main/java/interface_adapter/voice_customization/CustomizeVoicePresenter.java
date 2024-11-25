package interface_adapter.voice_customization;

import use_case.voice_customization.CustomizeVoiceOutputBoundary;
import use_case.voice_customization.CustomizeVoiceOutputData;

/**
 * Presenter for handling the output of voice customization.
 * Implements the output boundary to prepare the appropriate views based on the outcome.
 */
public class CustomizeVoicePresenter implements CustomizeVoiceOutputBoundary {

    /**
     * Prepares the success view with the given output data.
     * This method is invoked when the voice customization process succeeds.
     *
     * @param response the output data containing the results of the customization
     */
    @Override
    public void prepareSuccessView(CustomizeVoiceOutputData response) {
        // Handle successful view preparation (e.g., show updated voice settings)
        // Currently, no specific implementation.
    }

    /**
     * Prepares the failure view with the given error message.
     * This method is invoked when the voice customization process fails.
     *
     * @param error the error message to display to the user
     */
    @Override
    public void prepareFailView(String error) {
        // Handle failure view preparation (e.g., display error to user)
        // Currently, no specific implementation.
    }
}
