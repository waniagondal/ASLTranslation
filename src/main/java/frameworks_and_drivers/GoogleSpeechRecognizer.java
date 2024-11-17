package frameworks_and_drivers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.speech.v1.SpeechSettings;
import interface_adapters.SpeechRecognizer;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.protobuf.ByteString;

import java.io.FileInputStream;
import java.util.List;

public class GoogleSpeechRecognizer implements SpeechRecognizer {
    @Override
    public String recognize(byte[] audioData) throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("/Users/shengfang/IdeaProjects/CSC207-Project/credentials/summer-ranger-441414-f8-9e6018a05c25.json"));
        SpeechSettings speechSettings = SpeechSettings.newBuilder()
                .setCredentialsProvider(
                        FixedCredentialsProvider.create(credentials))
                .build();

        try (SpeechClient speechClient = SpeechClient.create(speechSettings)) {
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding
                            .LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();

            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(ByteString.copyFrom(audioData))
                    .build();

            RecognizeResponse response = speechClient.recognize(
                    config, audio);
            List<SpeechRecognitionResult> results =
                    response.getResultsList();

            StringBuilder transcription = new StringBuilder();
            for (SpeechRecognitionResult result : results) {
                SpeechRecognitionAlternative alternative =
                        result.getAlternativesList().get(0);
                transcription.append(alternative.getTranscript());
            }

            return transcription.toString();
        }
    }
}
