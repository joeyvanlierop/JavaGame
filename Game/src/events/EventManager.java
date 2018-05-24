package events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class EventManager
{
    private HashMap<Class<? extends Event>, ArrayList<IEventListener>> eventCallbackMap;

    public EventManager()
    {
        this.eventCallbackMap = new HashMap<>();
    }

    public void dispatchEvent(Event event)
    {
        ArrayList<IEventListener> classCallbacks = eventCallbackMap.get(event.getClass());

        if(classCallbacks == null)
        {
            return;
        }

        for(IEventListener listener : classCallbacks)
        {
            for(Method callback : listener.getClass().getMethods())
            {
                if(callback.isAnnotationPresent(EventHandler.class))
                {
                    if(callback.getAnnotation(EventHandler.class).value() == event.getClass())
                    {
                        try {
                            callback.invoke(listener);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void registerListener(IEventListener listener)
    {
        for(Method method : listener.getClass().getMethods())
        {
            if(method.isAnnotationPresent(EventHandler.class))
            {
                Class<? extends Event> value = method.getAnnotation(EventHandler.class).value();

                if(eventCallbackMap.containsKey(value))
                {
                    if(!eventCallbackMap.get(value).contains(listener))
                    {
                        eventCallbackMap.get(value).add(listener);
                    }
                }
                else
                {
                    ArrayList<IEventListener> registeredListeners = new ArrayList<>();
                    registeredListeners.add(listener);

                    eventCallbackMap.put(value, registeredListeners);
                }
            }
        }
    }
}
