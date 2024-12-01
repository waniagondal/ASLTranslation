package view;

import entity.AudioSettings;
import interface_adapter.customize_voice.CustomizeVoiceController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Hashtable;

public class VoiceSettingsView extends JPanel {

    private JFrame frame;
    private JLabel speedLabel;
    private JLabel voiceTypeLabel;
    private JLabel pitchLabel;

    private GlowButton setButton;

    private JSlider speedSlider;
    private JButton femaleButton;
    private JButton maleButton;
    private JSlider pitchSlider;

    private int SPEED_VALUE;
//    private int VOLUME_VALUE;
    private int VOICE_TYPE_VALUE;
    private int PITCH_VALUE;


    private final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private final Color ACCENT_COLOR = new Color(231, 76, 60);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color TEXT_COLOR = new Color(44, 62, 80);

    private CustomizeVoiceController customizeVoiceController;

    public void setCustomizeVoiceController(CustomizeVoiceController customizeVoiceController) {
        this.customizeVoiceController = customizeVoiceController;
    }


    public void setAudioSettings(AudioSettings audioSettings) {
        this.SPEED_VALUE = (int) audioSettings.getSpeed();
        this.PITCH_VALUE = (int) audioSettings.getPitch();

        if (audioSettings.getVoiceType()) {
            this.VOICE_TYPE_VALUE = 1;
        }
        else {
            this.VOICE_TYPE_VALUE = 0;
        }
    }

    public VoiceSettingsView(AudioSettings audioSettings) {
        this.SPEED_VALUE = (int) audioSettings.getSpeed();
        this.PITCH_VALUE = (int) audioSettings.getPitch();

        if (audioSettings.getVoiceType()) {
            this.VOICE_TYPE_VALUE = 1;
        }
        else {
            this.VOICE_TYPE_VALUE = 0;
        }

        initializeUI();
    }

    private void initializeUI() {
        this.frame = new JFrame("Text to Speech Settings");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setBackground(BACKGROUND_COLOR);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel sliderPanel = createSliderPanel();
        mainPanel.add(sliderPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        // hide the settings view initially to prevent wrong interaction
        frame.setVisible(false);
    }

    private JPanel createSliderPanel() {
        JPanel sliderPanel = new JPanel(new GridLayout(7, 1, 0, 2));
        sliderPanel.setBackground(BACKGROUND_COLOR);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        Font tickFont = new Font("Segoe UI", Font.BOLD, 15);

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Female"));
        labelTable.put(1, new JLabel("Male"));

        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 4, SPEED_VALUE);
        femaleButton = new JButton("Female");
        maleButton = new JButton("Male");
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        pitchSlider = new JSlider(JSlider.HORIZONTAL, -20, 20, PITCH_VALUE);

        speedLabel = new JLabel("Voice Speed: " + speedSlider.getValue());
        pitchLabel = new JLabel("Voice Pitch: " + pitchSlider.getValue());
        voiceTypeLabel = new JLabel("Voice Type: " + getVoiceType(VOICE_TYPE_VALUE));

        speedSlider.setPaintTicks(true);
        pitchSlider.setPaintTicks(true);

        speedSlider.setPaintLabels(true);
        pitchSlider.setPaintLabels(true);

        speedSlider.setMajorTickSpacing(1);
        pitchSlider.setMajorTickSpacing(10);

        updateVoiceTypeButtonStyle(femaleButton, maleButton);

        speedSlider.addChangeListener(e -> {speedLabel.setText("Voice Speed: " +
                speedSlider.getValue());});

        // Button for female voice type
        femaleButton.addActionListener(e -> {
            VOICE_TYPE_VALUE = 0;
            voiceTypeLabel.setText("Voice Type: Female");
            updateVoiceTypeButtonStyle(femaleButton, maleButton);
        });

        // Button for male voice type
        maleButton.addActionListener(e -> {
            VOICE_TYPE_VALUE = 1;
            voiceTypeLabel.setText("Voice Type: Male");
            updateVoiceTypeButtonStyle(femaleButton, maleButton);
        });

        pitchSlider.addChangeListener(e -> {pitchLabel.setText("Voice Pitch: " +
                pitchSlider.getValue());});

        speedSlider.setFont(tickFont);
        pitchSlider.setFont(tickFont);

        speedLabel.setFont(labelFont);
        voiceTypeLabel.setFont(labelFont);
        pitchLabel.setFont(labelFont);

        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(femaleButton);
        buttonPanel.add(maleButton);

        sliderPanel.add(voiceTypeLabel);
        sliderPanel.add(buttonPanel);
        sliderPanel.add(speedLabel);
        sliderPanel.add(speedSlider);
        sliderPanel.add(pitchLabel);
        sliderPanel.add(pitchSlider);

        return sliderPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        setButton = new GlowButton("Save Settings", PRIMARY_COLOR);
        setButton.addActionListener(e ->
                customizeVoice()
        );

        buttonPanel.add(setButton);

        return buttonPanel;
    }

    private void customizeVoice() {
        customizeVoiceController.execute(speedSlider.getValue(), VOICE_TYPE_VALUE == 1,
                pitchSlider.getValue());
        // Automatically shuts down the settings view when the settings are saved
        frame.setVisible(false);
    }

    private String getVoiceType(int voiceNumber) {
        if (voiceNumber == 0) {
            return "Female";
        }
        else {
            return "Male";
        }
    }

    private void updateVoiceTypeButtonStyle(JButton femaleButton, JButton maleButton) {
        femaleButton.setBackground(VOICE_TYPE_VALUE == 0 ? PRIMARY_COLOR : BACKGROUND_COLOR);
        femaleButton.setForeground(VOICE_TYPE_VALUE == 0 ? Color.WHITE : TEXT_COLOR);
        maleButton.setBackground(VOICE_TYPE_VALUE == 1 ? PRIMARY_COLOR : BACKGROUND_COLOR);
        maleButton.setForeground(VOICE_TYPE_VALUE == 1 ? Color.WHITE : TEXT_COLOR);
    }

    // The method that is called to open the settings view
    public void openSettings() {
        frame.setVisible(true);
    }

    private static class GlowButton extends JButton {
        private final Color baseColor;

        public GlowButton(String text, Color color) {
            super(text);
            this.baseColor = color;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setFont(new Font("Segoe UI", Font.BOLD, 16));
            setForeground(Color.WHITE);
            setPreferredSize(new Dimension(200, 50));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            g2d.setColor(baseColor);
            g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, 20, 20));

            g2d.setColor(Color.WHITE);
            FontMetrics fm = g2d.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(getText(), g2d);
            int x = (width - (int) r.getWidth()) / 2;
            int y = (height - (int) r.getHeight()) / 2 + fm.getAscent();
            g2d.drawString(getText(), x, y);
        }
    }
}
