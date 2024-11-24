package interface_adapter.customize_voice;

import use_case.customize_voice.CustomizeVoiceOutputBoundary;
import use_case.customize_voice.CustomizeVoiceOutputData;

public class CustomizeVoicePresenter implements CustomizeVoiceOutputBoundary {

    @Override
    public void prepareSuccessView(CustomizeVoiceOutputData response) {
        ;
    }

    @Override
    public void prepareFailView(String error) {
        ;
    }
}
