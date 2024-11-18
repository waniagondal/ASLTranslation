package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AudioTranscriptionTest {

    @Test
    void testGetText() {
        String expectedText = "test input";
        AudioTranscription transcription = new AudioTranscription(expectedText);

        String actualText = transcription.getText();

        assertEquals(expectedText, actualText, "getText return correctly");
    }

    @Test
    void testConstructorWithNull() {
        AudioTranscription transcription = new AudioTranscription(null);

        assertNull(transcription.getText(), "this should return null");
    }
}
