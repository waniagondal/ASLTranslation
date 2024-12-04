package view;

import java.awt.Color;

/**
 * The GestureBridgeConfiguration class contains all the constant values
 * used across the Gesture Bridge application for UI configuration,
 * layout settings, audio settings, font styles, dimensions, colors,
 * and other repeated values to ensure consistency throughout the application.
 */
public class GestureBridgeConfiguration {

    // Constants for grid layout
    /** Grid weight for the transcription panel in the layout. */
    protected static final double TRANSCRIPTION_PANEL_WEIGHT_X = 0.3;
    /** Grid weight for the webcam panel in the layout. */
    protected static final double WEBCAM_GRID_WEIGHT_X = 0.7;
    /** Grid weight for the webcam panel's vertical layout. */
    protected static final double WEBCAM_GRID_WEIGHT_Y = 0.6;
    /** Grid weight for the sign language panel's vertical layout. */
    protected static final double SIGN_LANGUAGE_PANEL_GRID_WEIGHT_Y = 0.4;
    /** Grid weight for the button panel in the layout. */
    protected static final double BUTTON_PANEL_WEIGHT_Y = 0.1;
    /** Insets for the grid layout (top and right). */
    protected static final int GRID_INSETS_TOP_RIGHT = 10;
    /** Grid width for the button panel. */
    protected static final int BUTTON_PANEL_GRID_WIDTH = 3;

    // Constants for audio
    /** Speed setting for speech synthesis in the audio settings. */
    protected static final double AUDIO_SETTINGS_SPEECH = 1.5;
    /** Pitch setting for speech synthesis in the audio settings. */
    protected static final double AUDIO_SETTING_PITCH = 6.0;

    // Constants for sizes, dimensions, and other repeated values
    /** Default width of the application frame. */
    protected static final int FRAME_WIDTH = 1280;
    /** Default height of the application frame. */
    protected static final int FRAME_HEIGHT = 800;
    /** Padding for borders within UI components. */
    protected static final int BORDER_PADDING = 20;
    /** Default width of the webcam display. */
    protected static final int WEB_CAM_WIDTH = 640;
    /** Default height of the webcam display. */
    protected static final int WEB_CAM_HEIGHT = 480;

    // Constants for font sizes and font
    /** Font size for the logo text. */
    protected static final int LOGO_FONT_SIZE = 28;
    /** Font size for title text. */
    protected static final int TITLE_FONT_SIZE = 18;
    /** Font size for text areas. */
    protected static final int TEXT_AREA_FONT_SIZE = 16;
    /** Font size for buttons. */
    protected static final int BUTTON_FONT_SIZE = 16;
    /** Default font type used in the application. */
    protected static final String FONT_TYPE = "Segoe UI";

    // Constants for button sizes
    /** Default width of buttons. */
    protected static final int BUTTON_WIDTH = 200;
    /** Default height of buttons. */
    protected static final int BUTTON_HEIGHT = 40;

    // Constants for rounded corner arc size
    /** Default arc size for rounded corners on UI elements. */
    protected static final int ARC_HEIGHT_WIDTH = 20;

    // Constants for color
    /** Primary color used throughout the UI. */
    protected static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    /** Secondary color used for UI highlights. */
    protected static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    /** Accent color used for special UI highlights. */
    protected static final Color ACCENT_COLOR = new Color(231, 76, 60);
    /** Default background color for panels. */
    protected static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    /** Default color for text. */
    protected static final Color TEXT_COLOR = new Color(44, 62, 80);
}
