package use_case.customize_voice;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;

public class CustomizeVoiceInteractor implements CustomizeVoiceInputBoundary {

    private final CustomizeVoiceDataAccessInterface voiceSettingsDataAccessObject;
    private final CustomizeVoiceOutputBoundary voiceSettingsPresenter;
    private final AudioSettingsFactory audioSettingsFactory;

    public CustomizeVoiceInteractor(CustomizeVoiceDataAccessInterface voiceSettingsDataAccessObject,
                                    CustomizeVoiceOutputBoundary voiceSettingsPresenter,
                                    AudioSettingsFactory audioSettingsFactory) {
        this.voiceSettingsDataAccessObject = voiceSettingsDataAccessObject;
        this.voiceSettingsPresenter = voiceSettingsPresenter;
        this.audioSettingsFactory = audioSettingsFactory;
    }

    @Override
    public void execute(CustomizeVoiceInputData voiceInputData) {
        final AudioSettings audioSettings = audioSettingsFactory.create(voiceInputData.getSpeed(),
                voiceInputData.getVoiceType(), voiceInputData.getPitch());

        voiceSettingsDataAccessObject.changeSettings(audioSettings);

        final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(audioSettings,
                false);
        voiceSettingsPresenter.prepareSuccessView(customizeVoiceOutputData);
    }
}
