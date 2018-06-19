package entities.systems;

import entities.EntityManager;
import entities.System;
import entities.components.CameraTargetComponent;
import entities.components.PositionComponent;
import game.Camera;
import game.GameManager;

import java.util.UUID;

public class CameraFollowSystem extends System
{
    public void update(EntityManager entityManager)
    {
        UUID target = entityManager.getEntity(CameraTargetComponent.class, PositionComponent.class);
        Camera camera = GameManager.getCamera();

        PositionComponent targetPosition = (PositionComponent) entityManager.getComponent(target, PositionComponent.class);

        int camX = (int) targetPosition.getX() - (camera.getViewportWidth() / 2);
        int camY = (int) targetPosition.getY() - (camera.getViewportHeight() / 2);

        if (camX > camera.getMaxOffsetX()) {
            camX = camera.getMaxOffsetX();
        }

        if (camX < camera.getMinOffsetX()) {
            camX = camera.getMinOffsetX();
        }

        if (camY > camera.getMaxOffsetY()) {
            camY = camera.getMaxOffsetY();
        }

        if (camY < camera.getMinOffsetY()) {
            camY = camera.getMinOffsetY();
        }

        camera.setX(camX);
        camera.setY(camY);
    }
}
