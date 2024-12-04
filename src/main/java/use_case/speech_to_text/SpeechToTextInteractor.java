package use_case.speech_to_text;

import interface_adapter.speech_to_text.SpeechRecognizerInterface;

/**
 * The use case for processing speech input and transcribing it into text.
 * This implements the SpeechInputBoundary and uses a SpeechRecognizer to do the actual work.
 */
public class SpeechToTextInteractor implements SpeechToTextInputBoundary {

    private final SpeechRecognizerInterface speechRecognizerInterface;
    private final SpeechToTextOutputBoundary speechToTextPresenter;

    /**
     * Constructs a new ProcessSpeechInputUseCase.
     *
     * @param speechRecognizerInterface the recognizer to convert audio into text.
     * @param outputBoundary   the boundary to deliver the transcription result.
     */
    public SpeechToTextInteractor(SpeechRecognizerInterface speechRecognizerInterface,
                                  SpeechToTextOutputBoundary outputBoundary) {
        this.speechRecognizerInterface = speechRecognizerInterface;
        this.speechToTextPresenter = outputBoundary;
    }

    /**
     * Starts the speech recognition process.
     *
     * @param inputData The input data (audio data) to recognize.
     * @throws Exception if there is an error during speech recognition.
     */
    public void processSpeech(SpeechToTextInputData inputData) throws Exception {
        final String onSpeechRecognition = speechRecognizerInterface.recognize(inputData.getAudioData());
        final SpeechToTextOutputData outputData = new SpeechToTextOutputData(onSpeechRecognition);
        speechToTextPresenter.deliverTranscription(outputData);
    }
}
