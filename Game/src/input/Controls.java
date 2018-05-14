package input;

import java.awt.event.KeyEvent;

public enum Controls
{
    UP(KeyEvent.VK_W),
    DOWN(KeyEvent.VK_S),
    LEFT(KeyEvent.VK_A),
    RIGHT(KeyEvent.VK_D);

    private int keyCode;

    Controls(int keyCode)
    {
        this.keyCode = keyCode;
    }

    public int getKeyCode()
    {
        return keyCode;
    }
}
