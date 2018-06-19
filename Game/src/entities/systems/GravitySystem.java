package entities.systems;

import entities.EntityManager;
import entities.System;
import entities.components.PhysicsComponent;
import entities.components.PositionComponent;

import java.util.ArrayList;
import java.util.UUID;

public class GravitySystem extends System
{
    public void update()
    {
        ArrayList<UUID> entityGroup = EntityManager.getEntityGroup(PositionComponent.class, PhysicsComponent.class);

        for(UUID ID : entityGroup)
        {
            PositionComponent positionComponent = (PositionComponent) EntityManager.getComponent(ID, PositionComponent.class);
            PhysicsComponent physicsComponent = (PhysicsComponent) EntityManager.getComponent(ID, PhysicsComponent.class);

            //positionComponent.setY();
        }
    }
}
