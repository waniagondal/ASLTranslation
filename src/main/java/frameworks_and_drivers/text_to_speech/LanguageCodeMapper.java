package frameworks_and_drivers.text_to_speech;

import java.util.HashMap;
import java.util.Map;

public class LanguageCodeMapper {

    private static final Map<String, String> LANGUAGE_CODE_MAP = new HashMap<>();

    static {
        LANGUAGE_CODE_MAP.put("English", "en-US");
        LANGUAGE_CODE_MAP.put("Spanish", "es-ES");
        LANGUAGE_CODE_MAP.put("Mandarin", "zh-CN");
        LANGUAGE_CODE_MAP.put("French", "fr-FR");
    }

    public static String getLanguageCode(String language) {
        return LANGUAGE_CODE_MAP.get(language);
    }
}
