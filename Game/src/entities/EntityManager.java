package entities;

import gfx.Renderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class EntityManager
{
    //https://cbpowell.wordpress.com/2012/10/30/entity-component-game-programming-using-jruby-and-libgdx-part-1/
    //https://github.com/JamesMcMahon/entitas-2d-roguelike/blob/master/Assets/Sources/Features/Input/InputSystem.cs
    //https://github.com/ClickerMonkey/Ents/blob/master/Java/src/org/magnos/entity/
    //https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013/

    public static HashMap<Class<? extends Component>, ArrayList<UUID>> componentPool = new HashMap<>();

    public static UUID createEntity()
    {
        UUID ID = UUID.randomUUID();
        //Entity entity = new Entity(ID);

        return ID;
    }

    public static void addComponent(UUID ID, Component component)
    {
        componentPool.putIfAbsent(component.getClass(), new ArrayList<UUID>());

        if(componentPool.get(component.getClass()).contains(ID))
        {
            componentPool.get(component.getClass()).add(ID);
        }
    }

    public boolean hasComponent(UUID ID, Component component)
    {
        if(componentPool.containsKey(component.getClass()))
        {
            return componentPool.get(component.getClass()).contains(ID);
        }

        return false;
    }

    public boolean hasComponent(UUID ID, Class<? extends Component> componentType)
    {
        if(componentPool.containsKey(componentType))
        {
            return componentPool.get(componentType).contains(ID);
        }

        return false;
    }

    public static void destroyEntity(Entity entity)
    {
        entityPool.remove(entity);
    }

    public EntityGroup getGroup(Class<? extends Component>... components)
    {
        EntityGroup entityGroup = new EntityGroup();

        for(Entity entity : entityPool)
        {
            if(entity.hasComponent(components))
            {
                entityGroup.addEntity(entity);
            }
        }

        return entityGroup;
    }
}
