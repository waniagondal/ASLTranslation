package use_case.text_to_speech;

import com.google.protobuf.ByteString;

/**
 * Represents the output data for the Text to Speech Use Case.
 */
public class TextToSpeechOutputData {
    private final ByteString audioContent;

    /**
     * Constructs an instance of TextToSpeechOutputData with the given audio content.
     *
     * @param audioContent the synthesized audio content in ByteString format
     */
    public TextToSpeechOutputData(ByteString audioContent) {
        this.audioContent = audioContent;
    }

    /**
     * Gets the synthesized audio content.
     *
     * @return the audio content as a ByteString
     */
    public ByteString getAudioContents() {
        return audioContent;
    }
}
