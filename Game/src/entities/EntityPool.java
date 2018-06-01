package entities;

import gfx.Renderer;

import java.util.ArrayList;

public final class EntityPool
{
    private static ArrayList<Entity> entityPool = new ArrayList<>();

    public static Entity createEntity()
    {
        Entity entity = new Entity();

        return entity;
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
