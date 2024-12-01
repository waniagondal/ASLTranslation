package use_case;

import data_access.VoiceDataAccessObject;
import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;
import interface_adapter.customize_voice.CustomizeVoicePresenter;
import org.junit.Test;
import use_case.customize_voice.*;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

public class CustomizeVoiceInteractorTest {

    @Test
    public void successTest() {
        CustomizeVoiceInputData inputData = new CustomizeVoiceInputData(2, false, 10);
        CustomizeVoiceDataAccessInterface voiceSettingsRepo = new VoiceDataAccessObject();

        AudioSettingsFactory factory = new AudioSettingsFactory();
        final AudioSettings settings = factory.create(2, false, 10);
        voiceSettingsRepo.changeSettings(settings);

        CustomizeVoiceOutputBoundary successPresenter = new CustomizeVoiceOutputBoundary() {
            @Override
            public void prepareSuccessView(CustomizeVoiceOutputData outputData) {
                assertEquals(2, settings.getSpeed());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }
        };

        CustomizeVoiceInputBoundary interactor = new CustomizeVoiceInteractor(voiceSettingsRepo,
                successPresenter, new AudioSettingsFactory());
        interactor.execute(inputData);
    }

    @Test
    public void successChangeSettingsTest() {
        CustomizeVoiceInputData inputData = new CustomizeVoiceInputData(2, false, 10);
        CustomizeVoiceDataAccessInterface voiceSettingsRepo = new VoiceDataAccessObject();

        AudioSettingsFactory factory = new AudioSettingsFactory();
        AudioSettings settings = factory.create(2, false, 10);
        voiceSettingsRepo.changeSettings(settings);

        CustomizeVoiceOutputBoundary successPresenter = new CustomizeVoiceOutputBoundary() {
            @Override
            public void prepareSuccessView(CustomizeVoiceOutputData outputData) {
                assertEquals(2, outputData.getAudioSettings().getSpeed());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }
        };

        CustomizeVoiceInputBoundary interactor = new CustomizeVoiceInteractor(voiceSettingsRepo,
                successPresenter, new AudioSettingsFactory());
        interactor.execute(inputData);
    }
}
