package entities.systems;

import entities.EntityManager;
import entities.System;
import entities.components.PositionComponent;
import entities.components.SpriteComponent;
import gfx.Renderer;

import java.util.ArrayList;
import java.util.UUID;

public class SpriteRendererSystem extends System
{
    public void render(EntityManager entityManager, Renderer renderer)
    {
        ArrayList<UUID> entityGroup = entityManager.getEntityGroup(SpriteComponent.class, PositionComponent.class);

        for(UUID ID : entityGroup)
        {
            SpriteComponent spriteComponent = (SpriteComponent) entityManager.getComponent(ID, SpriteComponent.class);
            PositionComponent positionComponent = (PositionComponent) entityManager.getComponent(ID, PositionComponent.class);

            if(positionComponent.getX() < 200 && positionComponent.getY() < 200)
            {
                renderer.renderSprite(spriteComponent.getSprite(), (int) positionComponent.getX(), (int) positionComponent.getY());
            }
        }
    }
}
