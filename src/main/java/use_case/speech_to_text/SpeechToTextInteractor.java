package use_case.speech_to_text;

import frameworks_and_drivers.speech_to_text.SpeechRecognizer;

import java.io.IOException;

/**
 * The use case for processing speech input and transcribing it into text.
 * This implements the SpeechInputBoundary and uses a SpeechRecognizer to do the actual work.
 */
public class SpeechToTextInteractor implements SpeechToTextInputBoundary {

    private final SpeechRecognizer speechRecognizer;
    // Renamed to better match CA
    private final SpeechToTextOutputBoundary speechToTextPresenter;

    /**
     * Constructs a new ProcessSpeechInputUseCase.
     *
     * @param speechRecognizer the recognizer to convert audio into text.
     * @param outputBoundary   the boundary to deliver the transcription result.
     */
    public SpeechToTextInteractor(SpeechRecognizer speechRecognizer, SpeechToTextOutputBoundary outputBoundary) {
        this.speechRecognizer = speechRecognizer;
        this.speechToTextPresenter = outputBoundary;
    }

    /**
     * Starts the speech recognition process.
     *
     * @param inputData The input data (audio data) to recognize.
     * @throws IOException if there is an error with the input/output operation.
     * @throws InterruptedException if the thread is interrupted during the recognition process.
     */
    public void processSpeech(SpeechToTextInputData inputData) throws Exception {
        String onSpeechRecognition = speechRecognizer.recognize(inputData.getAudioData());
        SpeechToTextOutputData outputData = new SpeechToTextOutputData(onSpeechRecognition);
        speechToTextPresenter.deliverTranscription(outputData);
    }
}
