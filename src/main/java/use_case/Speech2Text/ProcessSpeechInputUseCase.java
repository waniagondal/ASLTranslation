package use_case.Speech2Text;

import entity.AudioTranscription;
import interface_adapter.Speech2Text.SpeechInputBoundary;
import interface_adapter.Speech2Text.SpeechRecognizer;

/**
 * Use case for processing speech input.
 * This class implements the {@link SpeechInputBoundary} interface and is responsible for
 * converting audio data into a transcription using a speech recognition system.
 */
public class ProcessSpeechInputUseCase implements SpeechInputBoundary {
    /**
     * The speech recognizer used to process the audio data.
     */
    private final SpeechRecognizer speechRecognizer;

    /**
     * Constructs a new instance of {@code ProcessSpeechInputUseCase}.
     *
     * @param speechRecognizer The {@link SpeechRecognizer} responsible for recognizing speech
     *                         from audio data.
     */
    public ProcessSpeechInputUseCase(SpeechRecognizer speechRecognizer) {
        this.speechRecognizer = speechRecognizer;
    }

    /**
     * Processes the given audio data to produce a transcription.
     *
     * @param audioData The audio data in byte array format.
     * @return An {@link AudioTranscription} object containing the transcribed text.
     * @throws Exception If an error occurs during the speech recognition process.
     */
    @Override
    public AudioTranscription processSpeech(byte[] audioData) throws Exception {
        String text = speechRecognizer.recognize(audioData);
        return new AudioTranscription(text);
    }
}
