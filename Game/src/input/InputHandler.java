package input;

import gfx.Renderer;
import interfaces.IUpdatable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class InputHandler extends KeyAdapter implements IUpdatable
{
    private ArrayList<KeyEvent> pressedKeys = new ArrayList<>();
    private ArrayList<Map.Entry<Integer, Runnable>> registeredKeys = new ArrayList<>();

    public InputHandler(Renderer renderer)
    {
        renderer.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e)
    {
        addKey(e);
    }

    public void keyReleased(KeyEvent e)
    {
        removeKey(e);
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

    public void tick()
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
