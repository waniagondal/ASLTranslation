package use_case;

import frameworks_and_drivers.sign_language_translation.SignLanguageTranslationDataAccessObject;
import interface_adapter.sign_language_translation.SignLanguageTranslationDataAccessInterface;
import org.junit.jupiter.api.Test;
import use_case.sign_language_translation.*;

import static org.junit.jupiter.api.Assertions. *;

// The test needs to be rewritten to fit the structure of the current interactor (and names)
class TranslationInteractorTest {
    @Test
    void successTest() {
        // Create the translation object for testing
        // This whole part might be in the interactor
        // CreateTranslationFactory factory = new CreateTranslationFactory();
        // List<String> empty = new ArrayList<>();
        // Translation translation = factory.create("Hello World", "Mandarin", empty);

        // Create the input data
        SignLanguageTranslationInputData inputData = new SignLanguageTranslationInputData(
                "Mandarin", "Hello World");
        // Create the DAO
        SignLanguageTranslationDataAccessInterface translate = new SignLanguageTranslationDataAccessObject();

        //Creates the presenter for the successful case
        SignLanguageTranslationInputBoundary interactor = getSignLanguageTranslationInputBoundary(translate);
        interactor.execute(inputData);
    }

    private static SignLanguageTranslationInputBoundary getSignLanguageTranslationInputBoundary(
            SignLanguageTranslationDataAccessInterface translate) {
        SignLanguageTranslationOutputBoundary successPresenter = new SignLanguageTranslationOutputBoundary() {
            @Override
            public void prepareSuccessView(SignLanguageTranslationOutputData outputData) {
                // Check if the translation matches the desired meaning
                assertEquals("你好世界", outputData.getTranslatedText());
            }
        };

        return new SignLanguageTranslationInteractor(translate, successPresenter);
    }
}
