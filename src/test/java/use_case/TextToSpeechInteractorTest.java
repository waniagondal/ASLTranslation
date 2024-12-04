package use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.text_to_speech.TextToSpeechInputData;
import use_case.text_to_speech.TextToSpeechInteractor;
import use_case.text_to_speech.TextToSpeechOutputBoundary;
import interface_adapter.text_to_speech.TextToSpeechInterface;
import frameworks_and_drivers.text_to_speech.GoogleTextToSpeechGateway;
import entity.AudioSettings;
import com.google.protobuf.ByteString;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TextToSpeechInteractorTest {

    private TextToSpeechInteractor interactor;
    private ByteString capturedAudioContent;

    @BeforeEach
    public void setUp() {

        TextToSpeechOutputBoundary outputBoundary = outputData -> capturedAudioContent = outputData.getAudioContents();

        TextToSpeechInterface textToSpeechService = new GoogleTextToSpeechGateway();
        interactor = new TextToSpeechInteractor(outputBoundary, textToSpeechService);
    }

    @Test
    public void successTest() throws IOException, LineUnavailableException {
        // Prepare input data for the test
        AudioSettings audioSettings = new AudioSettings(1.0, false, 0.0);
        TextToSpeechInputData inputData = new TextToSpeechInputData(
                "Good Morning", "en-US", audioSettings);

        // Import Expected Output
        byte[] wavBytes = Files.readAllBytes(Paths.get("src/test/java/use_case/output.wav"));
        ByteString audioBytes = ByteString.copyFrom(wavBytes);

        // Execute the interactor with the input data
        interactor.execute(inputData);

        assertEquals(audioBytes, capturedAudioContent);
    }
}