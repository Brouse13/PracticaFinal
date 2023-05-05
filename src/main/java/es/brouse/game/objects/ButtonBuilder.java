package es.brouse.game.objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class in charge of the creation of the {@link JButton} that will
 * be on the interactive interfaces.
 */
public class ButtonBuilder {
    /*---------- PRIVATE ----------*/
    private final JButton button;

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance only with its name
     */
    public ButtonBuilder(String name) {
        this.button = new JButton(name);
    }

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance with its name and an icon.
     */
    public ButtonBuilder(String name, Icon icon) {
        this.button = new JButton(name, icon);
    }

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance with its name, icon and a listener
     */
    public ButtonBuilder(String name, Icon icon, ActionListener listener) {
        this.button = new JButton(name, icon);
        this.button.addActionListener(listener);
    }

    /**
     * Set the background color of the button to the specified by parameters.
     *
     * @param color color to set
     * @return the builder instance
     */
    public ButtonBuilder setBackgroundColor(Color color) {
        button.setBackground(color);
        return this;
    }

    /**
     * Set the size of the button to the specified by parameters.
     *
     * @param size size to set
     * @return the builder instance
     */
    public ButtonBuilder setSize(Dimension size) {
        button.setSize(size);
        return this;
    }

    /**
     * Get the associated swing component ({@link JButton}) that will
     * represent all the stored data.
     *
     * @return the swing JMenuBar
     */
    public JComponent getComponent() {
        return button;
    }
}