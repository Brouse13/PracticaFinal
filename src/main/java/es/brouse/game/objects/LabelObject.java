package es.brouse.game.objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JSplitPane} that will
 * be on the interactive interfaces.
 */
public class LabelObject implements Component {
    /*---------- PRIVATE ----------*/
    private final JLabel label;

    /**
     * Main class constructor able to create new {@link SplitObject}
     * instance only with its orientation.
     */
    public LabelObject(String name) {
        label = new JLabel(name);
        label.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public LabelObject setSize(Dimension size) {
        label.setSize(size);
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JSplitPanel
     */
    @Override
    public JComponent getComponent() {
        return label;
    }
}
