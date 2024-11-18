package controller;

import presenter.SignLanguagePresenter;

import java.io.IOException;

public class SignLanguageController {
    private final SignLanguagePresenter presenter;

    public SignLanguageController(SignLanguagePresenter presenter) {
        this.presenter = presenter;
    }

    public void startRecognition() throws IOException, InterruptedException {
        presenter.startRecognition();
    }
}
