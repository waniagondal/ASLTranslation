package interface_adapter.Text2Speech;

import use_case.text2speech.Text2SpeechOutputBoundary;
import use_case.text2speech.Text2SpeechOutputData;

public class Text2SpeechPresenter implements Text2SpeechOutputBoundary {

    @Override
    public void prepareSuccessView(Text2SpeechOutputData outputData) {
    }

    @Override
    public void prepareFailView(String error) {
    }
}