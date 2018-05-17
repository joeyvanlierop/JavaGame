package events;

import interfaces.IUpdatable;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager
{
    private HashMap<Class<? extends Event>, ArrayList<Runnable>> eventCallbackMap = new HashMap<>();

    public void dispatchEvent(Event event)
    {
        ArrayList<Runnable> callbacks = eventCallbackMap.get(event.getClass());

        for(Runnable callback : callbacks)
        {
            callback.run();
        }
    }

    public void registerListener(Object listener)
    {
        listeners.add(listener);
    }
}
