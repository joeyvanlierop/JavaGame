package gfx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Window {
    private JFrame frame;

    public Window(int width, int height, Renderer renderer)
    {
        frame = new JFrame("GameManager");

        renderer.setPreferredSize(new Dimension(width, height));
        renderer.setMaximumSize(new Dimension(width, height));
        renderer.setMinimumSize(new Dimension(width, height));

        frame.add(renderer);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public void close()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
