package app;

import entity.AudioSettings;
import entity.AudioSettingsFactory;
import view.GestureBridgeView;
import view.VoiceSettingsView;

/**
 * This module is responsible for initializing the views in the application,
 * including the main view and the settings view.
 */
public class ViewInitializationModule {

    /**
     * Initializes the main view of the GestureBridge application.
     *
     * @return the initialized GestureBridgeView instance.
     */
    public static GestureBridgeView initializeView() {
        return new GestureBridgeView();
    }

    /**
     * Initializes the voice settings view, setting initial audio settings.
     *
     * @return the initialized VoiceSettingsView instance.
     */
    public static VoiceSettingsView initializeVoiceSettingsView() {
        final AudioSettings audioSettings = new AudioSettingsFactory().create(1.5, true, 6.0);
        return new VoiceSettingsView(audioSettings);
    }
}
