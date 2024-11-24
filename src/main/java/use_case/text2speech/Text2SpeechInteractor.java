package use_case.text2speech;

// Imports the Google Cloud client library

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

public class Text2SpeechInteractor implements Text2SpeechInputBoundary{

    public Text2SpeechInteractor() {
    }

    @Override
    public void execute(Text2SpeechInputData Text2SpeechInputData) throws IOException, LineUnavailableException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("/Users/yibinwang/Desktop/summer-ranger-441414-f8-0a863841dab9.json"));

        TextToSpeechSettings settings = TextToSpeechSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

        // Instantiates a client
        ByteString audioContents;
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(settings)) {
            // Set the text input to be synthesized
            SynthesisInput input = SynthesisInput.newBuilder().setText(Text2SpeechInputData.getText()).build();
            // Get the required gender
            final boolean gender = Text2SpeechInputData.getGender();
            String genderValue = "FEMALE";
            if (gender == true){
                genderValue = "MALE";
            }
            // Build the voice request, select the language code and the ssml voice gender
            VoiceSelectionParams voice =
                    VoiceSelectionParams.newBuilder()
                            .setLanguageCode(Text2SpeechInputData.getLanguageCode())
                            .setSsmlGender(SsmlVoiceGender.valueOf(genderValue))
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
            AudioInputStream audioStream = new AudioInputStream(
                    new ByteArrayInputStream(audioContents.toByteArray()),
                    new AudioFormat(16000, 16, 1, true, false),
                    audioContents.size());

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream); // Open the AudioInputStream
            clip.start();
        }
        final Text2SpeechOutputData Text2SpeechOutputData = new Text2SpeechOutputData(audioContents);
    }
}
