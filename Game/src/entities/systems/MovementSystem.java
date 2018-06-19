package entities.systems;

import entities.EntityManager;
import entities.System;
import entities.components.MovementComponent;
import entities.components.PositionComponent;

import java.util.ArrayList;
import java.util.UUID;

public class MovementSystem extends System
{
    public void update(EntityManager entityManager)
    {
        ArrayList<UUID> entityGroup = entityManager.getEntityGroup(PositionComponent.class, MovementComponent.class);

        for(UUID ID : entityGroup)
        {
            PositionComponent positionComponent = (PositionComponent) entityManager.getComponent(ID, PositionComponent.class);
            MovementComponent movementComponent = (MovementComponent) entityManager.getComponent(ID, MovementComponent.class);

            while (movementComponent.getXMove() != 0)
            {
                if (Math.abs(movementComponent.getXMove()) > 1)
                {
                    positionComponent.moveX(abs(movementComponent.getXMove()));
                    movementComponent.setXMove(movementComponent.getXMove() - abs(movementComponent.getXMove()));
                } else {
                    positionComponent.moveX(movementComponent.getXMove());
                    movementComponent.setXMove(0);
                }
            }

            while (movementComponent.getYMove() != 0)
            {
                if (Math.abs(movementComponent.getYMove()) > 1)
                {
                    positionComponent.moveY(abs(movementComponent.getYMove()));
                    movementComponent.setYMove(movementComponent.getYMove() - abs(movementComponent.getYMove()));
                }
                else
                {
                    positionComponent.moveY(movementComponent.getYMove());
                    movementComponent.setXMove(0);
                }
            }
        }
    }

    private int abs(double i)
    {
        if (i < 0)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
