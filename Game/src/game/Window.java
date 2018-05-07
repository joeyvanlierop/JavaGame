package game;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;

    public Window(int width, int height, Game game)
    {
        frame = new JFrame("Game");

        game.renderer.setPreferredSize(new Dimension(width, height));
        game.renderer.setMaximumSize(new Dimension(width, height));
        game.renderer.setMinimumSize(new Dimension(width, height));

        frame.add(game.renderer);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        game.start();
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }
}
