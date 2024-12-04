package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

import entity.AudioSettings;
import interface_adapter.customize_voice.CustomizeVoiceController;
import interface_adapter.customize_voice.VoiceSettingsViewInterface;

/**
 * VoiceSettingsView is a panel that displays settings for
 * customizing voice settings such as speed, voice type, and pitch.
 */
public class VoiceSettingsView extends JPanel implements VoiceSettingsViewInterface {

    // Constants for UI dimensions and properties
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 450;
    private static final int MAX_VOICE_TYPE_VALUE = 1;
    private static final int MIN_VOICE_TYPE_VALUE = 0;
    private static final int SLIDER_MIN_SPEED = 0;
    private static final int SLIDER_MAX_SPEED = 4;
    private static final int MIN_PITCH_VALUE = -20;
    private static final int MAX_PITCH_VALUE = 20;
    private static final int PITCH_MAJOR_TICK_SPACING = 10;
    private static final int SLIDER_MAJOR_TICK_SPACING = 1;

    // Constants for layout and button dimensions
    private static final int BORDER_PADDING = 20;
    private static final int BORDER_HORIZONTAL_VERTICAL_GAP = 10;
    private static final int SLIDER_INSET_TOP_BOTTOM = 10;

    // Constants for colors
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);

    private static final String FEMALE_LABEL = "Female";
    private static final String MALE_LABEL = "Male";
    private static final String VOICE_SPEED_LABEL = "Voice Speed: ";
    private static final String VOICE_TYPE_LABEL = "Voice Type: ";
    private static final String VOICE_PITCH_LABEL = "Voice Pitch: ";
    private static final String SAVE_SETTINGS_BUTTON_TEXT = "Save Settings";

    private JFrame frame;
    private JLabel speedLabel;
    private JLabel voiceTypeLabel;
    private JLabel pitchLabel;

    private GlowButton setButton;

    private JSlider speedSlider;
    private JSlider voiceTypeSlider;
    private JSlider pitchSlider;

    private int speedValue;
    private int voiceTypeValue;
    private int pitchValue;

    private CustomizeVoiceController customizeVoiceController;

    /**
     * Constructor to initialize the VoiceSettingsView with given audio settings.
     *
     * @param audioSettings The initial audio settings to set.
     */
    public VoiceSettingsView(AudioSettings audioSettings) {
        this.speedValue = (int) audioSettings.getSpeed();
        this.pitchValue = (int) audioSettings.getPitch();
        if (audioSettings.getVoiceType()) {
            this.voiceTypeValue = 1;
        }
        else {
            this.voiceTypeValue = 0;
        }
        initializeUserInterface();
    }

    /**
     * Sets the customize voice controller.
     *
     * @param customizeVoiceController The controller to customize voice settings.
     */
    public void setCustomizeVoiceController(CustomizeVoiceController customizeVoiceController) {
        this.customizeVoiceController = customizeVoiceController;
    }

    /**
     * Updates the audio settings for the system.
     *
     * @param audioSettings the {@link AudioSettings} object containing the desired audio configuration.
     */
    @Override
    public void setAudioSettings(AudioSettings audioSettings) {
        this.speedValue = (int) audioSettings.getSpeed();
        this.pitchValue = (int) audioSettings.getPitch();
        if (audioSettings.getVoiceType()) {
            this.voiceTypeValue = 1;
        }
        else {
            this.voiceTypeValue = 0;
        }
    }

    /**
     * Initializes the UI components of the VoiceSettingsView.
     */
    private void initializeUserInterface() {
        frame = new JFrame("Text to Speech Settings");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setBackground(BACKGROUND_COLOR);

        final JPanel mainPanel = new JPanel(
                new BorderLayout(BORDER_HORIZONTAL_VERTICAL_GAP, BORDER_HORIZONTAL_VERTICAL_GAP));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(BORDER_PADDING, BORDER_PADDING, BORDER_PADDING, BORDER_PADDING));

        final JPanel sliderPanel = createSliderPanel();
        mainPanel.add(sliderPanel, BorderLayout.CENTER);

        final JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(false);
    }

    /**
     * Creates the panel containing the sliders for adjusting the voice settings.
     *
     * @return The panel containing the sliders.
     */
    private JPanel createSliderPanel() {
        final JPanel sliderPanel = new JPanel(new GridBagLayout());
        sliderPanel.setBackground(BACKGROUND_COLOR);
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(SLIDER_INSET_TOP_BOTTOM, 0, SLIDER_INSET_TOP_BOTTOM, 0);

        // Initialize sliders
        speedSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_SPEED, SLIDER_MAX_SPEED, speedValue);
        voiceTypeSlider = new JSlider(JSlider.HORIZONTAL, MIN_VOICE_TYPE_VALUE, MAX_VOICE_TYPE_VALUE, voiceTypeValue);
        pitchSlider = new JSlider(JSlider.HORIZONTAL, MIN_PITCH_VALUE, MAX_PITCH_VALUE, pitchValue);

        // Initialize labels
        speedLabel = new JLabel(VOICE_SPEED_LABEL + speedSlider.getValue());
        voiceTypeLabel = new JLabel(VOICE_TYPE_LABEL + getVoiceType(voiceTypeSlider.getValue()));
        pitchLabel = new JLabel(VOICE_PITCH_LABEL + pitchSlider.getValue());

        // Set up the sliders with ticks and labels
        setupSlider(speedSlider, SLIDER_MAJOR_TICK_SPACING);
        setupSlider(voiceTypeSlider, SLIDER_MAJOR_TICK_SPACING);
        setupSlider(pitchSlider, PITCH_MAJOR_TICK_SPACING);

        // Set the label table for voice type slider
        voiceTypeSlider.setLabelTable(createLabelTable());

        // Add listeners for the sliders
        addSliderListeners();

        // Add components to the panel
        addComponentsToPanel(sliderPanel, gbc);

        return sliderPanel;
    }

    /**
     * Configures a slider with ticks and a major tick spacing.
     *
     * @param slider The slider to configure.
     * @param tickSpacing The spacing between the major ticks on the slider.
     */
    private void setupSlider(JSlider slider, int tickSpacing) {
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(tickSpacing);
    }

    /**
     * Creates a label table for the voice type slider with the corresponding labels.
     *
     * @return A hashtable containing the labels for the voice type slider.
     */
    private Hashtable<Integer, JLabel> createLabelTable() {
        final Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(MIN_VOICE_TYPE_VALUE, new JLabel(FEMALE_LABEL));
        labelTable.put(MAX_VOICE_TYPE_VALUE, new JLabel(MALE_LABEL));
        return labelTable;
    }

    /**
     * Adds change listeners to the sliders to update the corresponding labels.
     */
    private void addSliderListeners() {
        speedSlider.addChangeListener(event -> speedLabel.setText(VOICE_SPEED_LABEL + speedSlider.getValue()));
        voiceTypeSlider.addChangeListener(
                event -> voiceTypeLabel.setText(VOICE_TYPE_LABEL + getVoiceType(voiceTypeSlider.getValue())));
        pitchSlider.addChangeListener(
                event -> pitchLabel.setText(VOICE_PITCH_LABEL + pitchSlider.getValue()));
    }

    /**
     * Adds the sliders and their labels to the given panel using GridBagLayout.
     *
     * @param panel The panel to which the components will be added.
     * @param gbc The GridBagConstraints to use for positioning the components.
     */
    private void addComponentsToPanel(JPanel panel, GridBagConstraints gbc) {
        gbc.gridy = 0;
        panel.add(voiceTypeLabel, gbc);
        gbc.gridy++;
        panel.add(voiceTypeSlider, gbc);
        gbc.gridy++;
        panel.add(speedLabel, gbc);
        gbc.gridy++;
        panel.add(speedSlider, gbc);
        gbc.gridy++;
        panel.add(pitchLabel, gbc);
        gbc.gridy++;
        panel.add(pitchSlider, gbc);
    }

    /**
     * Creates the panel containing the save button.
     *
     * @return The button panel.
     */
    private JPanel createButtonPanel() {
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(BACKGROUND_COLOR);

        setButton = new GlowButton(SAVE_SETTINGS_BUTTON_TEXT, PRIMARY_COLOR);
        setButton.addActionListener(event -> customizeVoice());

        buttonPanel.add(setButton);

        return buttonPanel;
    }

    /**
     * Executes the voice customization.
     */
    private void customizeVoice() {
        customizeVoiceController.execute(
                speedSlider.getValue(), voiceTypeSlider.getValue() != 0, pitchSlider.getValue());
        frame.setVisible(false);
    }

    /**
     * Gets the voice type string based on the slider value.
     *
     * @param voiceNumber The voice type value.
     * @return The voice type as a string.
     */
    private String getVoiceType(int voiceNumber) {
        String voice = FEMALE_LABEL;
        if (voiceNumber == MAX_VOICE_TYPE_VALUE) {
            voice = MALE_LABEL;
        }
        return voice;
    }

    /**
     * Opens the settings window.
     */
    public void openSettings() {
        frame.setVisible(true);
    }
}
