package use_case.text2speech;

import com.google.protobuf.ByteString;

import javax.sound.sampled.AudioInputStream;

/**
 * Output data for the Text to Speech Use Case.
 */
public class Text2SpeechOutputData {
    private final ByteString audioContents;

    public Text2SpeechOutputData(ByteString audioContents) {
        this.audioContents = audioContents;
    }

    public ByteString getAudioContents() {
        return audioContents;
    }
}
