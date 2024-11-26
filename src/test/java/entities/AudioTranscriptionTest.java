package entities;

import entity.AudioTranscription;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AudioTranscriptionTest {

    @Test
    void testAudioTranscriptionCreation() {
        String transcribedText = "This is a test transcription";

        AudioTranscription transcription = new AudioTranscription(transcribedText);

        assertEquals(transcribedText, transcription.getText());
    }

    @Test
    void testGetText() {
        String transcribedText = "Another test transcription";
        AudioTranscription transcription = new AudioTranscription(transcribedText);

        // Act
        String result = transcription.getText();

        // Assert
        assertEquals(transcribedText, result);
    }
}
