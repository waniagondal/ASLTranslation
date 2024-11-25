package use_case.customize_voice;

import entity.AudioParam;
import entity.AudioParamFactory;
import data_access.CustomizeVoiceDataAccessInterface;


/**
 * The Customize Voice Interactor.
 */
public class CustomizeVoiceInteractor implements CustomizeVoiceInputBoundary {
    private final CustomizeVoiceDataAccessInterface customizeVoiceDataAccessObject;
    private final CustomizeVoiceOutputBoundary audioParamPresenter;
    private final AudioParamFactory audioParamFactory;

    public CustomizeVoiceInteractor(CustomizeVoiceDataAccessInterface customizeVoiceDataAccessInterface,
                                    CustomizeVoiceOutputBoundary customizeVoiceOutputBoundary,
                                    AudioParamFactory audioParamFactory) {
        this.customizeVoiceDataAccessObject = customizeVoiceDataAccessInterface;
        this.audioParamPresenter = customizeVoiceOutputBoundary;
        this.audioParamFactory = audioParamFactory;
    }

    @Override
    public void execute(CustomizeVoiceInputData customizeVoiceInputData) {
        final AudioParam audioParam = audioParamFactory.create(customizeVoiceInputData.getVoiceSpeed(),
                                                                customizeVoiceInputData.getVoiceVolume(),
                                                                customizeVoiceInputData.getVoiceType(),
                                                                customizeVoiceInputData.getVoicePitch());
        customizeVoiceDataAccessObject.changeParam(audioParam);

        final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(false);

        audioParamPresenter.prepareSuccessView(customizeVoiceOutputData);
    }
}
