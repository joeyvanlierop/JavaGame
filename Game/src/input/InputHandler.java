package input;

import game.IUpdatable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class InputHandler implements IUpdatable, KeyEventDispatcher
{
    private final ArrayList<KeyEvent> pressedKeys = new ArrayList<>();
    private ArrayList<Map.Entry<Integer, Runnable>> registeredKeys = new ArrayList<>();

    public InputHandler()
    {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
    }

    @Override
    public boolean dispatchKeyEvent(final KeyEvent e) {
        int eventId = e.getID();

        switch (eventId) {
            case KeyEvent.KEY_PRESSED:
                this.addKey(e);
                break;
            case KeyEvent.KEY_RELEASED:
                this.removeKey(e);
                break;
        }

        return false;
    }

    private void addKey(KeyEvent keyCode)
    {
        // Don't Add Key To 'pressedKeys' If Already There
        if (pressedKeys.stream().anyMatch(key -> key.getKeyCode() == keyCode.getKeyCode()))
        {
            return;
        }

        pressedKeys.add(keyCode);
    }

    private void removeKey(KeyEvent keyCode)
    {
        for(Iterator<KeyEvent> i = pressedKeys.iterator(); i.hasNext();)
        {

            KeyEvent key = i.next();

            if(key.getKeyCode() == keyCode.getKeyCode())
            {
                i.remove();
            }
        }
    }

    public void registerKey(int keyCode, Runnable consumer)
    {
        registeredKeys.add(new AbstractMap.SimpleEntry<>(keyCode, consumer));
    }

    public void update()
    {
        pressedKeys.forEach(key ->
        {
            registeredKeys.forEach(consumer ->
            {
                if (key.getKeyCode() == consumer.getKey().intValue())
                {
                    consumer.getValue().run();
                }
            });
        });
    }
}
