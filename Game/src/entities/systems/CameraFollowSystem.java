package entities.systems;

import entities.EntityManager;
import entities.System;
import entities.components.CameraComponent;
import entities.components.CameraTargetComponent;
import entities.components.PositionComponent;

import java.util.UUID;

public class CameraFollowSystem extends System
{
    public void update()
    {
        UUID camera = EntityManager.getEntity(CameraComponent.class);
        UUID target = EntityManager.getEntity(CameraTargetComponent.class, PositionComponent.class);

        PositionComponent targetPosition = (PositionComponent) EntityManager.getComponent(target, PositionComponent.class);
        CameraComponent cameraComponent = (CameraComponent) EntityManager.getComponent(camera, CameraComponent.class);

        int camX = (int) targetPosition.getX() - (cameraComponent.getViewportWidth() / 2);
        int camY = (int) targetPosition.getY() - (cameraComponent.getViewportHeight() / 2);

        if (camX > cameraComponent.getMaxOffsetX()) {
            camX = cameraComponent.getMaxOffsetX();
        }

        if (camX < cameraComponent.getMinOffsetX()) {
            camX = cameraComponent.getMinOffsetX();
        }

        if (camY > cameraComponent.getMaxOffsetY()) {
            camY = cameraComponent.getMaxOffsetY();
        }

        if (camY < cameraComponent.getMinOffsetY()) {
            camY = cameraComponent.getMinOffsetY();
        }


        cameraComponent.setX(camX);
        cameraComponent.setY(camY);
    }
}
