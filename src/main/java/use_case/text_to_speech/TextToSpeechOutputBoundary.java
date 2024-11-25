package use_case.text_to_speech;

/**
 * Defines the contract for the output boundary of the Text-to-Speech use case.
 */
public interface TextToSpeechOutputBoundary {
    void prepareOutput(TextToSpeechOutputData outputData);
}