package input;

import gfx.Renderer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    public class Key {
        private boolean pressed = false;

        public void setValue(boolean value)
        {
            pressed = value;
        }

        public boolean isPressed()
        {
            return pressed;
        }
    }

    public InputHandler(Renderer renderer)
    {
        renderer.addKeyListener(this);
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public void keyPressed(KeyEvent e)
    {
        setKey(e.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent e)
    {
        setKey(e.getKeyCode(), false);
    }

    public void setKey(int keyCode, boolean value)
    {
        if (keyCode == KeyEvent.VK_W) {
            up.setValue(value);
        }
        if (keyCode == KeyEvent.VK_S) {
            down.setValue(value);
        }
        if (keyCode == KeyEvent.VK_A) {
            left.setValue(value);
        }
        if (keyCode == KeyEvent.VK_D) {
            right.setValue(value);
        }
    }
}
