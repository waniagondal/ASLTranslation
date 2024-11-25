//package app;
//
//import data_access.TranslationDataAccessObject;
//import interface_adapter.sign_language_translation.TranslationController;
//import interface_adapter.sign_language_translation.TranslationPresenter;
//import interface_adapter.sign_language_translation.TranslationViewModel;
//import use_case.sign_language_translation.TranslationInputBoundary;
//import use_case.sign_language_translation.TranslationInteractor;
//import use_case.sign_language_translation.TranslationOutputBoundary;
//import view.TranslationLanguageView;
//
//import javax.swing.*;
//
///**
// * Build a testing application (not injected into the whole project)
// */
//public class AppBuilder {
//    private final JPanel mainPanel = new JPanel();
//
//    // This is a hard dependency, might need to change to
//    private final TranslationDataAccessObject languageDataAccessObject = new TranslationDataAccessObject();
//
//    private TranslationLanguageView translationLanguageView;
//    private TranslationViewModel translationViewModel;
//
//    public AppBuilder() {
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//    }
//
//    /**
//     * Adds the Select Language View to the test view
//     * @return this builder
//     */
//    public AppBuilder addSelectLanguageView() {
//        translationViewModel = new TranslationViewModel();
//        translationLanguageView = new TranslationLanguageView(translationViewModel);
//        mainPanel.add(translationLanguageView);
//        return this;
//    }
//
//    /**
//     * Adds the Select Language use case to the test application.
//     * @return this builder
//     */
//    public AppBuilder addSelectLanguageUseCase() {
//        final TranslationOutputBoundary translationOutputBoundary = new TranslationPresenter(translationViewModel);
//        final TranslationInputBoundary selectLanguageInteractor = new TranslationInteractor(
//                languageDataAccessObject, translationOutputBoundary);
//        final TranslationController translationController = new TranslationController(selectLanguageInteractor);
//        translationLanguageView.setSelectLanguageController(translationController);
//        return this;
//    }
//
//    public JFrame build() {
//        final JFrame testApp = new JFrame("Translation Test");
//        testApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        testApp.add(mainPanel);
//        // Because there's only one view, there's currently no need to add a view manager model
//        return testApp;
//    }
//}
//
