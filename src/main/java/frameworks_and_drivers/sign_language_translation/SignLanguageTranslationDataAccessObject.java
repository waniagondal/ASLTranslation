package frameworks_and_drivers.sign_language_translation;

import java.util.HashMap;
import java.util.Map;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import interface_adapter.sign_language_translation.SignLanguageTranslationDataAccessInterface;
import secret_configuration.Configuration;

/**
 * DAO implementation for the Sign Language Translation use case.
 * This class provides signLanguageTranslationDisplay functionality using Google Cloud Translation API.
 */
public class SignLanguageTranslationDataAccessObject implements SignLanguageTranslationDataAccessInterface {

    private static final Map<String, String> LANGUAGE_CODES = new HashMap<>();
    private final String apiKey;

    static {
        LANGUAGE_CODES.put("English", "en");
        LANGUAGE_CODES.put("Spanish", "es");
        LANGUAGE_CODES.put("French", "fr");
        LANGUAGE_CODES.put("Mandarin", "zh-CN");
    }

    /**
     * Constructor initializes the DAO with an API key.
     *
     * @throws IllegalArgumentException if the API key is not found in the environment variables
     */
    public SignLanguageTranslationDataAccessObject() {
        this.apiKey = Configuration.getGoogleApiKey();
    }

    /**
     * Translates the given text into the specified language.
     *
     * @param language the target language for signLanguageTranslationDisplay
     * @param text the text to be translated
     * @return the translated version of the text
     */
    @Override
    public String translate(String language, String text) {
        System.out.println("Calling Cloud Translation API...");

        // Get the language code from the map
        final String languageCode = LANGUAGE_CODES.get(language);

        // Set up the Google Cloud Translate service
        final Translate translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();

        // Perform the signLanguageTranslationDisplay
        final Translation translation = translate.translate(
                text,
                Translate.TranslateOption.targetLanguage(languageCode));

        // Return the translated text
        return translation.getTranslatedText();
    }
}
