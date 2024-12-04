package frameworks_and_drivers.speech_to_text;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.SpeechSettings;
import com.google.protobuf.ByteString;
import interface_adapter.speech_to_text.SpeechRecognizerInterface;

/**
 * Concrete implementation of the SpeechRecognizer interface using Google Cloud's Speech-to-Text API.
 */
public class GoogleSpeechRecognizer implements SpeechRecognizerInterface {
    private static final int SAMPLE_RATE_HERTZ = 16000;

    /**
     * Recognizes speech from the given audio data using Google Cloud's Speech-to-Text API.
     *
     * @param audioData The audio data in byte array format.
     * @return A transcription of the audio as a String.
     * @throws Exception If an error occurs during the recognition process.
     */
    @Override
    public String recognize(byte[] audioData) throws Exception {
        final GoogleCredentials credentials = GoogleCredentials.fromStream(
                // Change file path to own API file
                Files.newInputStream(Paths.get(
                        "src/main/java/secret_configuration/summer-ranger-441414-f8-0a863841dab9.json")));
        final SpeechSettings speechSettings = SpeechSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

        try (SpeechClient speechClient = SpeechClient.create(speechSettings)) {
            final RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(SAMPLE_RATE_HERTZ)
                    .setLanguageCode("en-US")
                    .build();

            final RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(ByteString.copyFrom(audioData))
                    .build();

            final RecognizeResponse response = speechClient.recognize(config, audio);
            final List<SpeechRecognitionResult> results = response.getResultsList();
            final StringBuilder transcription = new StringBuilder();
            for (SpeechRecognitionResult result : results) {
                final SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                transcription.append(alternative.getTranscript());
            }
            return transcription.toString();
        }
    }
}

