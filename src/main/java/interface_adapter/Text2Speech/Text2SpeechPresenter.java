package interface_adapter.Text2Speech;

import use_case.text2speech.Text2SpeechOutputBoundary;
import use_case.text2speech.Text2SpeechOutputData;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;

import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.BitSet;

public class Text2SpeechPresenter implements Text2SpeechOutputBoundary {

    @Override
    public void prepareSuccessView(Text2SpeechOutputData outputData) throws LineUnavailableException, IOException {
        // Convert ByteString to an audio stream for playback
        ByteString audioContents = outputData.getAudioContents();
        AudioInputStream audioStream = new AudioInputStream(
                new ByteArrayInputStream(audioContents.toByteArray()),
                new AudioFormat(16000, 16, 1, true, false),
                audioContents.size());
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream); // Open the AudioInputStream
        clip.start();
    }

    @Override
    public void prepareFailView(String error) {
    }
}