package interface_adapter.text_to_speech;

import com.google.protobuf.ByteString;
import use_case.text_to_speech.TextToSpeechOutputBoundary;
import use_case.text_to_speech.TextToSpeechOutputData;
import view.ViewInterface;

/**
 * Responsible for presenting the output of the Text-to-Speech use case.
 */
public class TextToSpeechPresenter implements TextToSpeechOutputBoundary {
    // Add variable
    private ViewInterface view;

    public TextToSpeechPresenter(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void prepareOutput(TextToSpeechOutputData outputData) {
        // Delegate the actual audio playback to the AudioPlayer
        try {
            view.playAudio(outputData.getAudioContents());
            System.out.println("Audio content is ready, now playing audio...");
        } catch (Exception e) {
            System.err.println("Error during audio playback: " + e.getMessage());
        }
    }
}
