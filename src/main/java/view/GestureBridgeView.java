package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.google.protobuf.ByteString;
import entity.AudioSettings;
import entity.AudioSettingsFactory;
import interface_adapter.ViewInterface;
import interface_adapter.sign_language_translation.SignLanguageTranslationController;
import interface_adapter.speech_to_text.AudioRecorderInterface;
import interface_adapter.speech_to_text.SpeechToTextController;
import interface_adapter.text_to_speech.TextToSpeechController;

/**
 * GestureBridgeView is a JPanel that represents the graphical user interface (GUI)
 * for the GestureBridge application. It provides components for displaying sign language recognition,
 * transcription, signLanguageTranslationDisplay, and speech synthesis. It interacts with controllers for managing
 * sign language signLanguageTranslationDisplay and speech-to-text conversion.
*/
public class GestureBridgeView extends JPanel implements ViewInterface {

    private JTextArea signLanguageTextArea;
    private JTextArea transcriptionTextArea;
    private JComboBox<String> languageBox;
    private final GlowButton beginTranscriptionButton = new GlowButton(
            "Begin Transcription", GestureBridgeConfiguration.PRIMARY_COLOR);
    private final GlowButton endTranscriptionButton = new GlowButton(
            "End Transcription", GestureBridgeConfiguration.ACCENT_COLOR);

    private SignLanguageTranslationController signLanguageTranslationController;
    private SpeechToTextController speechToTextController;
    private AudioRecorderInterface audioRecorderForTranscription;
    private TextToSpeechController textToSpeechController;
    private AudioSettings audioSettings = new AudioSettingsFactory().create(
            GestureBridgeConfiguration.AUDIO_SETTINGS_SPEECH, true, GestureBridgeConfiguration.AUDIO_SETTING_PITCH);
    private Runnable onSettingsButtonClicked;

    /**
     * Constructs a new GestureBridgeView and initializes the user interface.
     * This constructor sets up the layout, colors, and interactive components of the UI.
     */
    public GestureBridgeView() {
        initializeUserInterface();
    }

    /**
     * Sets the controller responsible for translating sign language to text.
     *
     * @param viewSignLanguageTranslationController the controller to handle
     *                                              sign language signLanguageTranslationDisplay.
     */
    public void setTranslationController(SignLanguageTranslationController viewSignLanguageTranslationController) {
        this.signLanguageTranslationController = viewSignLanguageTranslationController;
    }

    /**
     * Sets the controller responsible for converting speech to text and assigns a new audio recorder for transcription.
     *
     * @param newSpeechToTextController the SpeechToTextController responsible for managing speech-to-text conversion
     * @param newAudioRecorderForTranscription the AudioRecorderInterface implementation to be used for
     *                                         audio transcription
     */
    public void setSpeechToTextController(SpeechToTextController newSpeechToTextController,
                                          AudioRecorderInterface newAudioRecorderForTranscription) {
        this.speechToTextController = newSpeechToTextController;
        this.audioRecorderForTranscription = newAudioRecorderForTranscription;
    }

    /**
     * Sets the controller responsible for the Text-to-Speech functionality.
     *
     * @param textToSpeechController the controller responsible for managing Text-to-Speech operations.
     */
    public void setTextToSpeechController(TextToSpeechController textToSpeechController) {
        this.textToSpeechController = textToSpeechController;

    }

    /**
     * Updates the audio settings for the system.
     *
     * @param audioSettings the {@link AudioSettings} object containing the desired audio configuration.
     */
    @Override
    public void setAudioSettings(AudioSettings audioSettings) {
        this.audioSettings = audioSettings;
    }

    /**
     * Sets the action to be performed when the settings button is clicked.
     * This method registers a Runnable to be executed when the settings button is clicked.
     *
     * @param onSettingsButtonClicked Runnable representing the action to execute when the settings button is clicked.
     */
    public void setOnSettingsButtonClicked(Runnable onSettingsButtonClicked) {
        this.onSettingsButtonClicked = onSettingsButtonClicked;
    }

    /**
     * Initializes the user interface (UI) for the GestureBridge application.
     * Sets up the main JFrame window, layouts, panels, and components including
     * text areas, buttons, labels, and other UI elements. This method is responsible
     * for defining the structure and appearance of the application's graphical interface.
     */
    private void initializeUserInterface() {
        final JFrame frame = new JFrame("GestureBridge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GestureBridgeConfiguration.FRAME_WIDTH, GestureBridgeConfiguration.FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);

        final JPanel mainPanel = createMainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * Creates and returns the main panel for the GestureBridge application.
     *
     * @return the main JPanel containing the UI components.
     */
    private JPanel createMainPanel() {
        final JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(
                GestureBridgeConfiguration.BORDER_PADDING, GestureBridgeConfiguration.BORDER_PADDING,
                GestureBridgeConfiguration.BORDER_PADDING, GestureBridgeConfiguration.BORDER_PADDING));

        signLanguageTextArea = new JTextArea();
        transcriptionTextArea = new JTextArea();
        languageBox = new JComboBox<>(new String[]{"English", "French", "Spanish", "Mandarin"});

        // Create GestureBridgeViewComponentCreation instance
        final GestureBridgeViewComponentCreation uiComponents = new GestureBridgeViewComponentCreation(
                signLanguageTextArea, transcriptionTextArea, languageBox);

        final JPanel logoPanel = createLogoPanel();
        mainPanel.add(logoPanel, BorderLayout.NORTH);

        final JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);
        final GridBagConstraints gbc = new GridBagConstraints();

        final JLabel webcamLabel = uiComponents.createWebcamLabel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = GestureBridgeConfiguration.WEBCAM_GRID_WEIGHT_X;
        gbc.weighty = GestureBridgeConfiguration.WEBCAM_GRID_WEIGHT_Y;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, GestureBridgeConfiguration.GRID_INSETS_TOP_RIGHT,
                GestureBridgeConfiguration.GRID_INSETS_TOP_RIGHT);
        contentPanel.add(webcamLabel, gbc);

        final JPanel signLanguagePanel = uiComponents.createSignLanguagePanel();
        gbc.gridy = 1;
        gbc.weighty = GestureBridgeConfiguration.SIGN_LANGUAGE_PANEL_GRID_WEIGHT_Y;
        contentPanel.add(signLanguagePanel, gbc);

        final JPanel transcriptionPanel = uiComponents.createTranscriptionPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = GestureBridgeConfiguration.TRANSCRIPTION_PANEL_WEIGHT_X;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        contentPanel.add(transcriptionPanel, gbc);

        final JPanel buttonPanel = createButtonPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = GestureBridgeConfiguration.BUTTON_PANEL_GRID_WIDTH;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = GestureBridgeConfiguration.BUTTON_PANEL_WEIGHT_Y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        contentPanel.add(buttonPanel, gbc);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    /**
     * Displays the predicted sign language recognition result in the sign language text area.
     *
     * @param prediction the predicted result of the sign language recognition to be displayed.
     */
    @Override
    public void signLanguageRecognitionDisplay(String prediction) {
        signLanguageTextArea.append(prediction);
    }

    /**
     * Initializes and starts the transcription process.
     * This method updates the transcription text area to indicate that the transcription process has begun,
     * disables the "Begin Transcription" button, and enables the "End Transcription" button.
     */
    private void beginTranscription() {
        transcriptionTextArea.setText("The transcription process has begun.\n");
        beginTranscriptionButton.setEnabled(false);
        endTranscriptionButton.setEnabled(true);
        beginRecording();
    }

    /**
     * Finalizes and stops the transcription process.
     * This method appends a message to the transcription text area indicating that the transcription process has ended,
     * enables the "Begin Transcription" button, and disables the "End Transcription" button.
     *
     * @throws Exception if an error occurs during the transcription finalization process.
     */
    private void endTranscription() throws Exception {
        transcriptionTextArea.append("The transcription process has ended.\n");
        beginTranscriptionButton.setEnabled(true);
        endTranscriptionButton.setEnabled(false);
        endRecordingAndProcess();
    }

    /**
     * Starts the audio recording process.
     * Utilizes the audio recorder instance to begin capturing audio input for transcription.
     */
    private void beginRecording() {
        audioRecorderForTranscription.start();
    }

    /**
     * Stops the audio recording and processes the recorded audio data.
     * Once recording stops, the audio data is fetched from the recorder and
     * sent to the Speech-to-Text controller for transcription.
     *
     * @throws Exception if an error occurs during the recording stop or audio processing.
     */
    private void endRecordingAndProcess() throws Exception {
        audioRecorderForTranscription.stop();
        final byte[] audioData = audioRecorderForTranscription.getAudioData();
        speechToTextController.processSpeech(audioData);
    }

    /**
     * Displays the transcription result of sign language in the transcription text area.
     *
     * @param transcription the transcription result of the sign language input to be displayed.
     */
    @Override
    public void signLanguageTranscriptionDisplay(String transcription) {
        transcriptionTextArea.setText("Transcription Result: " + transcription);
    }

    /**
     * Initiates the sign language translation process based on the selected language.
     * This method retrieves the selected language from the language selection box and
     * extracts the current text from the sign language recognition text area.
     * It then triggers the translation process using the signLanguageTranslationController.
     */
    private void translationProcess() {
        final String language = (String) languageBox.getSelectedItem();
        final String text = signLanguageTextArea.getText();
        signLanguageTranslationController.execute(language, text);
    }

    /**
     * Displays the translated sign language text in the sign language text area.
     * This method is used to update the UI by setting the provided translation into the
     * signLanguageTextArea. The translation is assumed to be a string that represents
     * the text form of the translated sign language.
     *
     * @param translation the translated text to be displayed in the sign language text area.
     */
    @Override
    public void signLanguageTranslationDisplay(String translation) {
        signLanguageTextArea.setText(translation);
    }

    /**
     * Initiates the Text-to-Speech (TTS) conversion for the text in the sign language text area.
     * This method retrieves the input text from the signLanguageTextArea, gets the selected
     * language from the language box, maps the language to its corresponding language code,
     * and passes the necessary information (text, language code, and audio settings) to
     * the textToSpeechController to convert the text to speech.
     *
     * @throws LineUnavailableException if the system's audio line is unavailable for output.
     * @throws IOException if there is an error in processing or writing audio data.
     */
    private void beginTextToSpeech() throws LineUnavailableException, IOException {
        final String inputText = signLanguageTextArea.getText();
        final String language = (String) languageBox.getSelectedItem();
        final String languageCode = LanguageCodeMapper.getLanguageCode(language);
        final AudioSettings newAudioSettings = this.audioSettings;
        textToSpeechController.execute(inputText, languageCode, newAudioSettings);
    }

    /**
     * Plays the provided audio content.
     * This method converts the provided ByteString audio content into an AudioInputStream,
     * then uses the system's default Clip to play the audio.
     *
     * @param audioContents the audio data in ByteString format to be played.
     * @throws LineUnavailableException if a line (e.g., audio output) is unavailable for playback.
     * @throws IOException if an I/O error occurs while reading the audio or opening the clip.
     */
    @Override
    public void playAudio(ByteString audioContents) throws LineUnavailableException, IOException {
        // Convert ByteString to AudioInputStream
        final AudioInputStream audioStream = new AudioInputStream(
                new ByteArrayInputStream(audioContents.toByteArray()),
                new AudioFormat(16000, 16, 1, true, false),
                audioContents.size());

        // Get the system's default clip to play the audio
        final Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    /**
     * Creates a panel containing control buttons for various functionalities
     * such as signLanguageTranslationDisplay, text-to-speech, and transcription management.
     * @return a JPanel containing action buttons.
     */
    public JPanel createButtonPanel() {
        final JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
        panel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);

        final GlowButton translateButton = new GlowButton("Translate", GestureBridgeConfiguration.SECONDARY_COLOR);
        final GlowButton textToSpeechButton = new GlowButton("Text to Speech",
                GestureBridgeConfiguration.SECONDARY_COLOR);

        // Add listeners to buttons
        translateButton.addActionListener(event -> translationProcess());
        textToSpeechButton.addActionListener(event -> {
            try {
                beginTextToSpeech();
            }
            catch (LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        beginTranscriptionButton.addActionListener(event -> beginTranscription());
        endTranscriptionButton.addActionListener(event -> {
            try {
                endTranscription();
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        panel.add(translateButton);
        panel.add(textToSpeechButton);
        panel.add(beginTranscriptionButton);
        panel.add(endTranscriptionButton);

        return panel;
    }

    /**
     * Creates and returns a JPanel that contains the application's logo or title.
     * @return a JPanel containing the application's logo or title.
     */
    public JPanel createLogoPanel() {
        final JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);

        final JLabel logoTextLabel = new JLabel("GestureBridge");
        logoTextLabel.setFont(new Font(GestureBridgeConfiguration.FONT_TYPE,
                Font.BOLD, GestureBridgeConfiguration.LOGO_FONT_SIZE));
        logoTextLabel.setForeground(GestureBridgeConfiguration.PRIMARY_COLOR);

        final JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);
        titlePanel.add(logoTextLabel);

        final JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        settingsPanel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);
        final JButton settingsButton = new GlowButton("Settings", GestureBridgeConfiguration.PRIMARY_COLOR);

        settingsButton.addActionListener(event -> {
            if (onSettingsButtonClicked != null) {
                onSettingsButtonClicked.run();
            }
        });
        settingsPanel.add(settingsButton);

        logoPanel.add(titlePanel, BorderLayout.CENTER);
        logoPanel.add(settingsPanel, BorderLayout.EAST);

        return logoPanel;
    }
}
