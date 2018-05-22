package events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class EventManager
{
    private HashMap<Class<? extends Event>, ArrayList<Method>> eventCallbackMap;

    public EventManager()
    {
        this.eventCallbackMap = new HashMap<>();
    }

    public void dispatchEvent(Event event)
    {
        ArrayList<Method> callbacks = eventCallbackMap.get(event.getClass());

        if(callbacks == null)
        {
            return;
        }

        for(Method callback : callbacks)
        {
            //TODO: Invoke Method
        }
    }

    public void registerListener(Object listener)
    {
        for(Method method : listener.getClass().getMethods())
        {
            if(method.isAnnotationPresent(EventHandler.class))
            {
                Class<? extends Event> value = method.getAnnotation(EventHandler.class).value();

                if(eventCallbackMap.containsKey(value))
                {
                    eventCallbackMap.get(value).add(method);
                }
                else
                {
                    ArrayList<Method> callbacks = new ArrayList<>();
                    callbacks.add(method);

                    eventCallbackMap.put(value, callbacks);
                }
            }
        }
    }
}
