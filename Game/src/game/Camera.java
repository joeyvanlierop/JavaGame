package game;

import entities.EntityManager;
import entities.components.PositionComponent;
import level.TiledMap;

import java.util.UUID;

public class Camera {
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;
    private UUID targetID;

    public Camera(int viewportWidth, int viewportHeight)
    {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
    }

    public void init(UUID target, TiledMap map)
    {
        this.maxOffsetX = map.getWidth() * 16 - viewportWidth;
        this.maxOffsetY = map.getHeight() * 16 - viewportHeight;
        this.minOffsetX = 0;
        this.minOffsetY = 0;

        this.targetID = target;
    }

    public int getX()
    {
        //PositionComponent target = (PositionComponent) EntityManager.getComponent(this.targetID, PositionComponent.class);

        //int camX = (int) this.target.getX() + (this.target.getWidth() / 2) - (viewportWidth / 2);
        //int camX = (int) target.getX();
        int camX = 300 - (viewportWidth / 2);

        if (camX > maxOffsetX)
            return maxOffsetX;

        if (camX < minOffsetX)
            return minOffsetX;

        return camX;
    }

    public int getY()
    {
        //PositionComponent target = (PositionComponent) EntityManager.getComponent(this.targetID, PositionComponent.class);

        //int camY = (int) target.getY() + (target.getHeight() / 2) - (viewportHeight / 2);
        //int camY = (int) target.getY();
        int camY = 300 - (viewportHeight / 2);

        if (camY > maxOffsetY)
            return maxOffsetY;

        if (camY < minOffsetY)
            return minOffsetY;

        return camY;
    }

    public int getViewportWidth()
    {
        return viewportWidth;
    }

    public int getViewportHeight()
    {
        return viewportHeight;
    }
}
