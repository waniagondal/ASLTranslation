package use_case.voice_customization;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.voice_customization.CustomizeVoiceDataAccessInterface;


/**
 * The Customize Voice Interactor.
 */
public class CustomizeVoiceInteractor implements CustomizeVoiceInputBoundary {
    private final CustomizeVoiceDataAccessInterface customizeVoiceDataAccessObject;
    private final CustomizeVoiceOutputBoundary audioParamPresenter;
    private final AudioSettingsFactory audioSettingsFactory;

    public CustomizeVoiceInteractor(CustomizeVoiceDataAccessInterface customizeVoiceDataAccessInterface,
                                    CustomizeVoiceOutputBoundary customizeVoiceOutputBoundary,
                                    AudioSettingsFactory audioSettingsFactory) {
        this.customizeVoiceDataAccessObject = customizeVoiceDataAccessInterface;
        this.audioParamPresenter = customizeVoiceOutputBoundary;
        this.audioSettingsFactory = audioSettingsFactory;
    }

    @Override
    public void execute(CustomizeVoiceInputData customizeVoiceInputData) {
        final AudioSettings audioSettings = audioSettingsFactory.create(customizeVoiceInputData.getVoiceSpeed(),
                                                                customizeVoiceInputData.getVoiceVolume(),
                                                                customizeVoiceInputData.getVoiceType(),
                                                                customizeVoiceInputData.getVoicePitch());
        customizeVoiceDataAccessObject.changeParam(audioSettings);

        final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(false);

        audioParamPresenter.prepareSuccessView(customizeVoiceOutputData);
    }
}
