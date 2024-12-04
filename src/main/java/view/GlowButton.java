package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

/**
 * GlowButton is a custom JButton with a glowing effect on hover.
 * It provides enhanced visual feedback by changing its appearance
 * when the mouse hovers over it. This button is designed for use in
 * modern GUI applications.
 */

public class GlowButton extends JButton {

    /**
     * The base color of the button when it is not hovered.
     */
    private final Color baseColor;

    /**
     * The color of the button's border and background when hovered.
     */
    private final Color hoverColor = new Color(64, 224, 208);

    /**
     * A flag indicating whether the button is currently hovered by the mouse.
     */
    private boolean isHovered;

    /**
     * Constructs a new GlowButton with the specified text and base color.
     *
     * @param text the text to be displayed on the button.
     * @param baseColor the base color of the button when it is not hovered.
     */
    protected GlowButton(String text, Color baseColor) {
        super(text);
        this.baseColor = baseColor;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font(GestureBridgeConfiguration.FONT_TYPE, Font.BOLD,
                GestureBridgeConfiguration.BUTTON_FONT_SIZE));
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(GestureBridgeConfiguration.BUTTON_WIDTH,
                GestureBridgeConfiguration.BUTTON_HEIGHT));

        // Add hover listener to update hover state and repaint on mouse events
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int width = getWidth();
        final int height = getHeight();

        // Use hover color if hovered, otherwise use base color
        if (isHovered) {
            g2d.setColor(hoverColor);
        }
        else {
            g2d.setColor(baseColor);
        }

        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height,
                GestureBridgeConfiguration.ARC_HEIGHT_WIDTH,
                GestureBridgeConfiguration.ARC_HEIGHT_WIDTH));

        g2d.setColor(Color.WHITE);
        final FontMetrics fm = g2d.getFontMetrics();
        final int x = (width - fm.stringWidth(getText())) / 2;
        final int y = (height - fm.getHeight()) / 2 + fm.getAscent();
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}
