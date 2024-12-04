package interface_adapter.customize_voice;

import entity.AudioSettings;
import interface_adapter.ViewInterface;
import use_case.customize_voice.CustomizeVoiceOutputBoundary;
import use_case.customize_voice.CustomizeVoiceOutputData;

/**
 * The presenter responsible for updating the views with the customized voice settings.
 * This class acts as an intermediary between the use case layer and the view layer. It prepares
 * and updates the views (GestureBridgeView and VoiceSettingsView) based on the outcome of the voice
 * customization process, such as setting the customized audio settings after a successful update.
 */
public class CustomizeVoicePresenter implements CustomizeVoiceOutputBoundary {
    private final ViewInterface view;
    private final VoiceSettingsViewInterface settingsView;

    /**
     * Constructs a CustomizeVoicePresenter with the specified views.
     *
     * @param view the main application view that will display the updated audio settings.
     * @param settingsView the settings view that will also be updated with the new audio settings.
     */
    public CustomizeVoicePresenter(ViewInterface view, VoiceSettingsViewInterface settingsView) {
        this.view = view;
        this.settingsView = settingsView;
    }

    /**
     * Prepares the success view by updating the views with the new customized audio settings.
     * After the customization process is successful, this method updates the main view (GestureBridgeView)
     * and the settings view (VoiceSettingsView) with the new audio settings, and prints the settings
     * to the console for debugging purposes.
     *
     * @param outputData the data containing the updated audio settings.
     */
    @Override
    public void prepareSuccessView(CustomizeVoiceOutputData outputData) {
        final AudioSettings settings = outputData.getAudioSettings();
        view.setAudioSettings(settings);
        settingsView.setAudioSettings(settings);
        System.out.println("Settings After \n"
                + "Speed: " + settings.getSpeed()
                + "\nVoice Type: " + settings.getVoiceType()
                + "\nPitch: " + settings.getPitch());
    }
}
