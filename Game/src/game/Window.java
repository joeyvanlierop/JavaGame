package game;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;

    public Window(int width, int height, Game main)
    {
        frame = new JFrame("Game");

        main.setPreferredSize(new Dimension(width, height));
        main.setMaximumSize(new Dimension(width, height));
        main.setMinimumSize(new Dimension(width, height));

        frame.add(main);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        main.start();
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }
}
