package input;

import gfx.Renderer;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class InputHandler extends KeyAdapter
{
    private static boolean[] keys = new boolean[255];

    public InputHandler(Renderer renderer)
    {
        renderer.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e)
    {
        setKey(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e)
    {
        setKey(e.getKeyCode(), false);
    }

    private void setKey(int keyCode, boolean value)
    {
        keys[keyCode] = value;
    }

    public static boolean getKey(int keyCode)
    {
        return keys[keyCode];
    }

    public static boolean getKey(KeyEvent keyCode)
    {
        return keys[keyCode.getKeyCode()];
    }
}
