package entities.systems;

import entities.EntityManager;
import entities.EntitySystem;
import entities.components.PositionComponent;
import entities.components.SpriteComponent;
import gfx.Renderer;

import java.util.ArrayList;
import java.util.UUID;

public class SpriteRendererEntitySystem extends EntitySystem
{
    public void render(Renderer renderer)
    {
        System.out.println("TEST");
        ArrayList<UUID> entityGroup = EntityManager.getEntityGroup(SpriteComponent.class, PositionComponent.class);

        for(UUID ID : entityGroup)
        {
            SpriteComponent spriteComponent = (SpriteComponent) EntityManager.getComponent(ID, SpriteComponent.class);
            PositionComponent positionComponent = (PositionComponent) EntityManager.getComponent(ID, PositionComponent.class);

            renderer.renderSprite(spriteComponent.getSprite(), (int) positionComponent.getX(), (int) positionComponent.getY());
        }
    }
}
