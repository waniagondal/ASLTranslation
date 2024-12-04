package view;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class that maps language names to their respective language codes.
 * This class provides a way to retrieve the correct language code for a given language name.
 * The language codes are based on the format used by Google Cloud's Text-to-Speech API.
 */
public class LanguageCodeMapper {

    // A static map to store the language names and their corresponding language codes
    private static final Map<String, String> LANGUAGE_CODE_MAP = new HashMap<>();

    static {
        // Pre-populating the map with some common languages and their codes
        LANGUAGE_CODE_MAP.put("English", "en-US");
        LANGUAGE_CODE_MAP.put("Spanish", "es-ES");
        LANGUAGE_CODE_MAP.put("Mandarin", "zh-CN");
        LANGUAGE_CODE_MAP.put("French", "fr-FR");
    }

    /**
     * Retrieves the language code corresponding to the given language name.
     *
     * @param language The name of the language (e.g., "English", "Spanish").
     * @return The corresponding language code (e.g., "en-US", "es-ES"), or null if no mapping exists.
     */
    public static String getLanguageCode(String language) {
        return LANGUAGE_CODE_MAP.get(language);
    }
}
