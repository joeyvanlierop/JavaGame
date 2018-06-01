package entities;

import java.util.ArrayList;

public class EntityGroup
{
    private ArrayList<Entity> entityGroup = new ArrayList<>();

    public EntityGroup()
    {

    }

    public void addEntity(Entity entity)
    {
        if(!entityGroup.contains(entity))
        {
            entityGroup.add(entity);
        }
    }

    public ArrayList<Entity> getEntities()
    {
        return entityGroup;
    }
}
