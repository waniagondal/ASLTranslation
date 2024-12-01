package interface_adapter.customize_voice;

import entity.AudioSettings;
import use_case.customize_voice.CustomizeVoiceOutputBoundary;
import use_case.customize_voice.CustomizeVoiceOutputData;
import view.GestureBridgeView;
import view.ViewInterface;
import view.VoiceSettingsView;

public class CustomizeVoicePresenter implements CustomizeVoiceOutputBoundary {
    private final ViewInterface view;
    private final VoiceSettingsView settingsView;

    public CustomizeVoicePresenter(GestureBridgeView view, VoiceSettingsView settingsView) {
        this.view = view;
        this.settingsView = settingsView;
    }

    @Override
    public void prepareSuccessView(CustomizeVoiceOutputData outputData) {
        AudioSettings settings = outputData.getAudioSettings();
        view.setAudioSettings(settings);
        settingsView.setAudioSettings(settings);
        System.out.println("Settings After \n"
                + "Speed: " + settings.getSpeed()
                + "\nVoice Type: " + settings.getVoiceType()
                + "\nPitch: " + settings.getPitch());
    }

    @Override
    public void prepareFailView(String error) {
    }
}
