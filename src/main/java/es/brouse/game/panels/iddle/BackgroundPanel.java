package es.brouse.game.panels.iddle;

import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class used to create the logo of the game as an image.
 */
public class BackgroundPanel extends JPanel implements Panel {

    /**
     * Main class constructor used to create and instance new
     * {@link BackgroundPanel} instances.
     */
    public BackgroundPanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frame = new Dimension((int) (size.getWidth() - 100), ((int) (size.getHeight() - 100)));

        final BufferedImage image = new ImageUtils().loadResource("background.jpg");
        final ImageBuilder imageBuilder = new ImageBuilder(image).setDimensions(frame);

        add(imageBuilder.getComponent());
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}