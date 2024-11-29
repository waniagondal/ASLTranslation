package use_case;

import frameworks_and_drivers.text_to_speech.AudioPlayer;
import interface_adapter.text_to_speech.TextToSpeechPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.text_to_speech.TextToSpeechInputData;
import use_case.text_to_speech.TextToSpeechOutputData;
import use_case.text_to_speech.TextToSpeechInteractor;
import use_case.text_to_speech.TextToSpeechOutputBoundary;
import frameworks_and_drivers.text_to_speech.TextToSpeechInterface;
import frameworks_and_drivers.text_to_speech.GoogleTextToSpeechGateway;
import entity.AudioSettings;
import com.google.protobuf.ByteString;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TextToSpeechInteractorTest {

    private TextToSpeechOutputBoundary outputBoundary;
    private TextToSpeechInteractor interactor;
    private TextToSpeechInterface TextToSpeechService;
    private ByteString capturedAudioContent;

    @BeforeEach
    public void setUp() {

        outputBoundary = new TextToSpeechOutputBoundary() {
            @Override
            public void prepareOutput(TextToSpeechOutputData outputData) {
                capturedAudioContent = outputData.getAudioContents();
            }
        };

        TextToSpeechService = new GoogleTextToSpeechGateway();
        interactor = new TextToSpeechInteractor(outputBoundary, TextToSpeechService);
    }

    @Test
    public void successTest() throws IOException {
        // Prepare input data for the test
        AudioSettings audioSettings = new AudioSettings(1.0, 1.0, false, 0.0);
        TextToSpeechInputData inputData = new TextToSpeechInputData("Good Morning", "en-US", audioSettings);

        // Import Expected Output
        byte[] wavBytes = Files.readAllBytes(Paths.get("src/test/java/use_case/output.wav"));
        ByteString audioBytes = ByteString.copyFrom(wavBytes);

        // Execute the interactor with the input data
        interactor.execute(inputData);

        assertEquals(audioBytes, capturedAudioContent);
    }
}



