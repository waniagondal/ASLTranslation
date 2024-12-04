package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * This class is responsible for creating and managing various UI components used
 * in the Gesture Bridge application, including panels for sign language recognition
 * and transcription output.
 */
public class GestureBridgeViewComponentCreation {

    private final JTextArea signLanguageTextArea;
    private final JTextArea transcriptionTextArea;
    private final JComboBox<String> languageBox;

    /**
     * Constructor to initialize the GestureBridgeViewComponentCreation with
     * sign language and transcription text areas, and a language combo box.
     *
     * @param signLanguageTextArea the text area for sign language recognition output
     * @param transcriptionTextArea the text area for transcription output
     * @param languageBox the combo box for selecting the language
     */
    public GestureBridgeViewComponentCreation(JTextArea signLanguageTextArea, JTextArea transcriptionTextArea,
                                              JComboBox<String> languageBox) {
        this.signLanguageTextArea = signLanguageTextArea;
        this.transcriptionTextArea = transcriptionTextArea;
        this.languageBox = languageBox;
    }

    /**
     * Creates and returns a JLabel representing the webcam feed display.
     * The label is configured with specific dimensions, color, text, and border.
     *
     * @return a JLabel configured to display the webcam feed
     */
    public JLabel createWebcamLabel() {
        final JLabel label = new JLabel("Webcam Feed");
        label.setPreferredSize(new Dimension(
                GestureBridgeConfiguration.WEB_CAM_WIDTH, GestureBridgeConfiguration.WEB_CAM_HEIGHT));
        label.setBackground(Color.BLACK);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(GestureBridgeConfiguration.PRIMARY_COLOR, 2));
        return label;
    }

    /**
     * Creates and returns a JPanel for displaying sign language recognition results.
     * The panel includes a title label, a text area for displaying the recognition results,
     * and a combo box for language selection.
     *
     * @return a JPanel configured for sign language recognition output
     */
    public JPanel createSignLanguagePanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);

        final JLabel titleLabel = new JLabel("Sign Language Recognition");
        titleLabel.setFont(new Font(GestureBridgeConfiguration.FONT_TYPE,
                Font.BOLD, GestureBridgeConfiguration.TITLE_FONT_SIZE));
        titleLabel.setForeground(GestureBridgeConfiguration.PRIMARY_COLOR);
        panel.add(titleLabel, BorderLayout.NORTH);

        signLanguageTextArea.setEditable(true);
        signLanguageTextArea.setFont(new Font(GestureBridgeConfiguration.FONT_TYPE, Font.PLAIN,
                GestureBridgeConfiguration.TEXT_AREA_FONT_SIZE));
        signLanguageTextArea.setLineWrap(true);
        signLanguageTextArea.setWrapStyleWord(true);
        signLanguageTextArea.setBackground(Color.WHITE);
        signLanguageTextArea.setForeground(GestureBridgeConfiguration.TEXT_COLOR);

        final JScrollPane scrollPane = new JScrollPane(signLanguageTextArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(GestureBridgeConfiguration.SECONDARY_COLOR));

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(languageBox, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Creates a panel for displaying the transcription results.
     * The panel includes a title label and a text area for displaying the transcription output.
     *
     * @return a JPanel for displaying transcription results
     */
    public JPanel createTranscriptionPanel() {
        final JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBackground(GestureBridgeConfiguration.BACKGROUND_COLOR);

        final JLabel titleLabel = new JLabel("Transcription");
        titleLabel.setFont(new Font(GestureBridgeConfiguration.FONT_TYPE, Font.BOLD,
                GestureBridgeConfiguration.TITLE_FONT_SIZE));
        titleLabel.setForeground(GestureBridgeConfiguration.PRIMARY_COLOR);
        panel.add(titleLabel, BorderLayout.NORTH);

        transcriptionTextArea.setEditable(false);
        transcriptionTextArea.setFont(new Font(GestureBridgeConfiguration.FONT_TYPE, Font.PLAIN,
                GestureBridgeConfiguration.TEXT_AREA_FONT_SIZE));
        transcriptionTextArea.setLineWrap(true);
        transcriptionTextArea.setWrapStyleWord(true);
        transcriptionTextArea.setBackground(Color.WHITE);
        transcriptionTextArea.setForeground(GestureBridgeConfiguration.TEXT_COLOR);

        final JScrollPane scrollPane = new JScrollPane(transcriptionTextArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(GestureBridgeConfiguration.SECONDARY_COLOR));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}
