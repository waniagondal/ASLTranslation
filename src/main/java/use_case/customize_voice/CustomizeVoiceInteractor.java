package use_case.customize_voice;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.customize_voice.CustomizeVoiceDataAccessInterface;

/**
 * The interactor responsible for managing the voice customization process.
 * This class interacts with data access objects and presenters to customize
 * the voice settings based on user input.
 */
public class CustomizeVoiceInteractor implements CustomizeVoiceInputBoundary {

    private final CustomizeVoiceDataAccessInterface voiceSettingsDataAccessObject;
    private final CustomizeVoiceOutputBoundary voiceSettingsPresenter;
    private final AudioSettingsFactory audioSettingsFactory;

    /**
     * Constructs a new CustomizeVoiceInteractor with the provided dependencies.
     *
     * @param voiceSettingsDataAccessObject The data access object for interacting with voice settings.
     * @param voiceSettingsPresenter        The presenter responsible for showing the success view.
     * @param audioSettingsFactory         The factory used to create AudioSettings objects.
     */
    public CustomizeVoiceInteractor(CustomizeVoiceDataAccessInterface voiceSettingsDataAccessObject,
                                    CustomizeVoiceOutputBoundary voiceSettingsPresenter,
                                    AudioSettingsFactory audioSettingsFactory) {
        this.voiceSettingsDataAccessObject = voiceSettingsDataAccessObject;
        this.voiceSettingsPresenter = voiceSettingsPresenter;
        this.audioSettingsFactory = audioSettingsFactory;
    }

    /**
     * Executes the voice customization logic, including creating new audio settings,
     * saving them, and preparing the success view to be shown to the user.
     *
     * @param voiceInputData The input data containing the user's voice customization preferences.
     */
    @Override
    public void execute(CustomizeVoiceInputData voiceInputData) {
        // Create new AudioSettings object using the provided voice customization data
        final AudioSettings audioSettings = audioSettingsFactory.create(voiceInputData.getSpeed(),
                voiceInputData.getVoiceType(), voiceInputData.getPitch());

        // Update the settings in the data access object
        voiceSettingsDataAccessObject.changeSettings(audioSettings);

        // Prepare the output data and present the success view to the user
        final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(audioSettings);
        voiceSettingsPresenter.prepareSuccessView(customizeVoiceOutputData);
    }
}
