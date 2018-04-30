package game;

import entities.Entity;
import entities.Player;
import level.Level;
import tiles.Tile;

public class Camera
{
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;
    private Entity target;

    public Camera(Level level, Player target, int viewportWidth, int viewportHeight)
    {
        this.maxOffsetX = level.getWidth() * Tile.TILESIZE - viewportWidth;
        this.maxOffsetY = level.getWidth() * Tile.TILESIZE - viewportHeight;
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
