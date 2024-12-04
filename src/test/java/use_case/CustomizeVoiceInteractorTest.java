package use_case;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import frameworks_and_drivers.customize_voice.VoiceDataAccessObject;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;
import org.junit.Test;
import use_case.customize_voice.*;

import static org.junit.jupiter.api.Assertions.*;

public class CustomizeVoiceInteractorTest {

    @Test
    public void successTest() {
        CustomizeVoiceInputData inputData = new CustomizeVoiceInputData(2, false, 10);
        CustomizeVoiceDataAccessInterface voiceSettingsRepo = new VoiceDataAccessObject();

        AudioSettingsFactory factory = new AudioSettingsFactory();
        final AudioSettings settings = factory.create(2, false, 10);
        voiceSettingsRepo.changeSettings(settings);

        CustomizeVoiceOutputBoundary successPresenter = outputData -> assertEquals(
                2, settings.getSpeed());

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

        CustomizeVoiceInputBoundary interactor = getCustomizeVoiceInputBoundary(voiceSettingsRepo);
        interactor.execute(inputData);
    }

    private static CustomizeVoiceInputBoundary getCustomizeVoiceInputBoundary(
            CustomizeVoiceDataAccessInterface voiceSettingsRepo) {
        CustomizeVoiceOutputBoundary successPresenter = outputData -> assertEquals(
                2, outputData.getAudioSettings().getSpeed());

        return new CustomizeVoiceInteractor(voiceSettingsRepo,
                successPresenter, new AudioSettingsFactory());
    }
}
