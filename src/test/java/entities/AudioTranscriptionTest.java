package entities;

import entity.AudioTranscription;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AudioTranscriptionTest {

    @Test
    void testAudioTranscriptionCreation() {
        // Arrange
        String transcribedText = "This is a test transcription";

        // Act
        AudioTranscription transcription = new AudioTranscription(transcribedText);

        // Assert
        assertEquals(transcribedText, transcription.getText());
    }

    @Test
    void testGetText() {
        // Arrange
        String transcribedText = "Another test transcription";
        AudioTranscription transcription = new AudioTranscription(transcribedText);

        // Act
        String result = transcription.getText();

        // Assert
        assertEquals(transcribedText, result);
    }
}
