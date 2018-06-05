package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class EntityManager
{
    //https://cbpowell.wordpress.com/2012/10/30/entity-component-game-programming-using-jruby-and-libgdx-part-1/
    //https://github.com/JamesMcMahon/entitas-2d-roguelike/blob/master/Assets/Sources/Features/Input/InputSystem.cs
    //https://github.com/ClickerMonkey/Ents/blob/master/Java/src/org/magnos/entity/
    //https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013/

    private static HashMap<Class<? extends Component>, HashMap<UUID, ArrayList<Component>>> componentPool = new HashMap<>();

    public static UUID createEntity()
    {
        UUID ID = UUID.randomUUID();

        return ID;
    }

    public static void destroyEntity(UUID ID)
    {
        for(HashMap IDS : componentPool.values())
        {
            IDS.remove(ID);
        }
    }

    public static void addComponent(UUID ID, Component component)
    {
        // Instantiate Keys If Absent
        componentPool.putIfAbsent(component.getClass(), new HashMap<>());
        componentPool.get(component.getClass()).putIfAbsent(ID, new ArrayList<>());

        // Link Component To ID
        componentPool.get(component.getClass()).get(ID).add(component);
    }

    public static void addSingletonComponent(UUID ID, Component component)
    {
        if(!hasComponent(ID, component.getClass()))
        {
            addComponent(ID, component);
        }
        else
        {
            java.lang.System.out.println("SingletonComponent Already Exists");
        }
    }

    public static boolean hasComponent(UUID ID, Class<? extends Component> component)
    {
        if(componentPool.containsKey(component))
        {
            return componentPool.get(component).containsKey(ID);
        }

        return false;
    }

    public static Component getComponent(UUID ID, Class<? extends Component> component)
    {
        return componentPool.get(component).get(ID).get(0);
    }

    public static ArrayList<Component> getComponents(UUID ID, Class<? extends Component> component)
    {
        return componentPool.get(component).get(ID);
    }

    public static ArrayList<UUID> getEntityGroup(Class<? extends Component>... components)
    {
        ArrayList<UUID> entityGroup = new ArrayList<>();

        for(Class<? extends Component> component : components)
        {
            if(componentPool.containsKey(component))
            {
                entityGroup.addAll(componentPool.get(component).keySet());
            }
        }

        return entityGroup;
    }
}
