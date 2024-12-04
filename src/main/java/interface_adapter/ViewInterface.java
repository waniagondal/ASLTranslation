package interface_adapter;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import com.google.protobuf.ByteString;
import entity.AudioSettings;

/**
 * An interface for the GestureBridgeView that is for dependency inversion (will be passed into the presenter
 * in place of the view model).
 */
public interface ViewInterface {

    /**
     * Displays the translation onto the view.
     * @param translation the translation that needs to be displayed
     */
    void signLanguageTranslationDisplay(String translation);

    /**
     * Display the speech transcription on the view.
     * @param transcription the transcribed text that needs to be displayed
     */
    void signLanguageTranscriptionDisplay(String transcription);

    /**
     * Update the view with the recognition result (prediction). Appends each predicted letter to the text area.
     * @param prediction the output data containing the result (prediction)
     */
    void signLanguageRecognitionDisplay(String prediction);

    /**
     * Plays the audio of the given text.
     * @param audioContents the byte string of the audio
     * @throws LineUnavailableException if the audio line cannot be opened due to resource restrictions
     * @throws IOException if an I/O error occurs while playing the audio
     */
    void playAudio(ByteString audioContents) throws LineUnavailableException, IOException;

    /**
     * Sets the audio settings that customizes the text-to-speech output.
     * @param audioSettings the audio settings
     */
    void setAudioSettings(AudioSettings audioSettings);
}

