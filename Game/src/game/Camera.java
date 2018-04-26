package game;

import entities.Entity;
import entities.Player;

public class Camera {
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;

    private Entity target;

    public Camera(int maxOffsetX, int maxOffsetY, int viewportWidth, int viewportHeight, Player target)
    {
        this.maxOffsetX = maxOffsetX - viewportWidth;
        this.maxOffsetY = maxOffsetY - viewportHeight;
        this.minOffsetX = 0;
        this.minOffsetY = 0;
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.target = target;
    }

    public int getX()
    {
        int camX = (int) target.getX() - viewportWidth / 2;

        if (camX > maxOffsetX)
            return maxOffsetX;

        if (camX < minOffsetX)
            return minOffsetX;

        return camX;
    }

    public int getY()
    {
        int camY = (int) target.getY() - viewportHeight / 2;

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
