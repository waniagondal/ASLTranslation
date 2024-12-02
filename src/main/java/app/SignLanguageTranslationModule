package app;

import frameworks_and_drivers.sign_language_translation.SignLanguageTranslationDataAccessObject;
import interface_adapter.sign_language_translation.SignLanguageTranslationController;
import interface_adapter.sign_language_translation.SignLanguageTranslationPresenter;
import use_case.sign_language_translation.SignLanguageTranslationInputBoundary;
import use_case.sign_language_translation.SignLanguageTranslationInteractor;
import use_case.sign_language_translation.SignLanguageTranslationOutputBoundary;
import view.GestureBridgeView;

/**
 * This module initializes the Sign Language Translation functionality, including the controller and related components.
 */
public class SignLanguageTranslationModule {

    /**
     * Initializes the Sign Language Translation module, including the controller and services.
     *
     * @param gestureBridgeView the main application view for communication with presenters.
     * @return the SignLanguageTranslationController instance.
     */
    public static SignLanguageTranslationController initialize(GestureBridgeView gestureBridgeView) {
        final SignLanguageTranslationDataAccessObject dataAccessObject = new SignLanguageTranslationDataAccessObject();
        final SignLanguageTranslationOutputBoundary outputBoundary = new SignLanguageTranslationPresenter(
                gestureBridgeView);
        final SignLanguageTranslationInputBoundary interactor = new SignLanguageTranslationInteractor(
                dataAccessObject, outputBoundary);
        return new SignLanguageTranslationController(interactor);
    }
}
