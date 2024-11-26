package interface_adapter.customize_voice;

import entity.AudioSettings;
import use_case.customize_voice.CustomizeVoiceOutputBoundary;
import use_case.customize_voice.CustomizeVoiceOutputData;
import view.GestureBridgeView;

public class CustomizeVoicePresenter implements CustomizeVoiceOutputBoundary {
    private final GestureBridgeView view;

    public CustomizeVoicePresenter(GestureBridgeView view) {this.view = view;}

    @Override
    public void prepareSuccessView(CustomizeVoiceOutputData outputData) {
        AudioSettings settings = outputData.getAudioSettings();
        view.setAudioSettings(settings);

    }

    @Override
    public void prepareFailView(String error) {
    }
}
