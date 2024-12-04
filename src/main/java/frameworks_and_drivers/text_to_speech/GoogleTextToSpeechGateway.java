package frameworks_and_drivers.text_to_speech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.TextToSpeechSettings;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import interface_adapter.text_to_speech.TextToSpeechInterface;
import use_case.text_to_speech.TextToSpeechInputData;
import use_case.text_to_speech.TextToSpeechOutputData;

/**
 * Implementation of the TextToSpeechInterface using Google Cloud Text-to-Speech API.
 */
public class GoogleTextToSpeechGateway implements TextToSpeechInterface {

    private final String credentialsPath;

    public GoogleTextToSpeechGateway() {
        this.credentialsPath = "src/main/java/secret_configuration/summer-ranger-441414-f8-0a863841dab9.json";
    }

    /**
     * This method uses the provided text input data to synthesize speech audio.
     * It leverages Google Cloud's Text-to-Speech client library, allowing for configurable
     * parameters such as language, voice gender, pitch, and speaking rate.
     *
     * @param inputData the input data containing text to be synthesized and audio configuration parameters.
     *                  Includes text, language code, gender, pitch, and speaking rate.
     * @return a TextToSpeechOutputData object containing the synthesized audio as a byte stream.
     * @throws IOException if there is an error accessing the
     *     credentials file or initializing the Text-to-Speech client.
     */
    @Override
    public TextToSpeechOutputData convertTextToSpeech(TextToSpeechInputData inputData) throws IOException {
        final GoogleCredentials credentials = GoogleCredentials.fromStream(
                Files.newInputStream(Paths.get(credentialsPath)));
        final TextToSpeechSettings settings = TextToSpeechSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

        try (TextToSpeechClient client = TextToSpeechClient.create(settings)) {
            // Set the text input to be synthesized
            final SynthesisInput input = SynthesisInput.newBuilder().setText(inputData.getText()).build();

            // Determine voice gender
            final String genderValue;
            if (inputData.getGender()) {
                genderValue = "MALE";
            }
            else {
                genderValue = "FEMALE";
            }

            final VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode(inputData.getLanguageCode())
                    .setSsmlGender(SsmlVoiceGender.valueOf(genderValue))
                    .build();

            final AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setPitch(inputData.getPitch())
                    .setAudioEncoding(AudioEncoding.LINEAR16)
                    .setSpeakingRate(inputData.getSpeakingRate())
                    .build();

            final SynthesizeSpeechResponse response = client.synthesizeSpeech(input, voice, audioConfig);

            final ByteString audioContents = response.getAudioContent();
            return new TextToSpeechOutputData(audioContents);
        }
    }
}

