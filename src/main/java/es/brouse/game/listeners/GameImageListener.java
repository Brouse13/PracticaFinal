package es.brouse.game.listeners;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.panels.game.GameController;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GameImageListener extends MouseAdapter {
    private final List<SplitImage> images;

    private static JLabel lastClick;

    private final GameController controller;

    public GameImageListener(GameController controller, List<SplitImage> images) {
        this.controller = controller;
        this.images = images;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getComponent();

        //If is the first click, we mark the component with a red border
        if (lastClick == null) {
            label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            lastClick = label;
            return;
        }

        //If not, we swipe the components
        int last_id = Integer.parseInt(lastClick.getName());
        int current_id = Integer.parseInt(label.getName());


        SplitImage tmp = images.get(last_id);
        Icon icon = lastClick.getIcon();

        images.set(last_id, images.get(current_id));
        lastClick.setIcon(label.getIcon());
        images.set(current_id, tmp);
        label.setIcon(icon);

        //We refresh the screen
        Screen.refresh(GameScreen.getInstance());

        //Reset variables
        lastClick.setBorder(BorderFactory.createEmptyBorder());
        lastClick = null;


        //Check the end of the game and end listener
        if (validate()) controller.endGame();

    }

    /**
     * Check if the elements are in order.
     *
     * @return if the gam is solved
     */
    private boolean validate() {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getIndex() != i) return false;
        }
        return true;
    }
}
