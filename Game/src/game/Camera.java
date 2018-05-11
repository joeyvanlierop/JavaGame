package game;

import entities.Entity;
import level.Level;
import tiles.Tile;

public class Camera {
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;
    private Entity target;

    public Camera(int viewportWidth, int viewportHeight)
    {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
    }

    public void init(Entity target, Level level)
    {
        this.maxOffsetX = level.getWidth() * Tile.TILESIZE - viewportWidth;
        this.maxOffsetY = level.getHeight() * Tile.TILESIZE - viewportHeight;
        this.minOffsetX = 0;
        this.minOffsetY = 0;

        this.target = target;
    }

    public int getX()
    {
        int camX = (int) target.getX() + (target.getWidth() / 2) - (viewportWidth / 2);

        if (camX > maxOffsetX)
            return maxOffsetX;

        if (camX < minOffsetX)
            return minOffsetX;

        return camX;
    }

    public int getY()
    {
        int camY = (int) target.getY() + (target.getHeight() / 2) - (viewportHeight / 2);

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
