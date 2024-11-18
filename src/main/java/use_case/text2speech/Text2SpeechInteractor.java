package use_case.text2speech;

// Imports the Google Cloud client library

import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Text2SpeechInteractor implements Text2SpeechInputBoundary{
    private final Text2SpeechOutputBoundary userpresenter;

    public Text2SpeechInteractor(Text2SpeechOutputBoundary text2SpeechOutputBoundary) {
        this.userpresenter = text2SpeechOutputBoundary;
    }

    @Override
    public void execute(Text2SpeechInputData Text2SpeechInputData) throws IOException {
        // Instantiates a client
        ByteString audioContents;
        AudioInputStream audioStream;
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            // Set the text input to be synthesized
            SynthesisInput input = SynthesisInput.newBuilder().setText(Text2SpeechInputData.getText()).build();
            // Get the required gender
            final boolean gender = Text2SpeechInputData.getGender();
            // Build the voice request, select the language code and the ssml voice gender
            VoiceSelectionParams voice =
                    VoiceSelectionParams.newBuilder()
                            .setLanguageCode(Text2SpeechInputData.getLanguageCode())
                            .setSsmlGender(SsmlVoiceGender.valueOf(String.valueOf(gender)))
                            .build();

            // Select the type of audio file you want returned
            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setPitch(Text2SpeechInputData.getPitch())
                    .setAudioEncoding(AudioEncoding.LINEAR16)  // Use LINEAR16 for playback compatibility
                    .setSpeakingRate(Text2SpeechInputData.getSpeakingRate())
                    .setVolumeGainDb(Text2SpeechInputData.getVolume())
                    .build();

            // Perform the text-to-speech request
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            // Get the audio contents from the response
            audioContents = response.getAudioContent();

            // Convert ByteString to an audio stream for playback
            audioStream = new AudioInputStream(
                    new ByteArrayInputStream(audioContents.toByteArray()),
                    new AudioFormat(16000, 16, 1, true, false),
                    audioContents.size());
        }
        final Text2SpeechOutputData Text2SpeechOutputData = new Text2SpeechOutputData(audioStream);
    }
}
