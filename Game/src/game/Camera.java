package game;

import entities.EntityManager;
import entities.components.PositionComponent;
import level.TiledMap;

import java.util.UUID;

public class Camera
{
    private int x;
    private int y;
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;

    public Camera(int viewportWidth, int viewportHeight)
    {
       this(0, 0, viewportWidth, viewportHeight);
    }

    public Camera(int x, int y, int viewportWidth, int viewportHeight)
    {
        this.x = x;
        this.y = y;
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
    }

    public void setBounds(TiledMap map)
    {
        this.maxOffsetX = map.getWidth() * 16 - viewportWidth;
        this.maxOffsetY = map.getHeight() * 16 - viewportHeight;
        this.minOffsetX = 0;
        this.minOffsetY = 0;
    }

    public void clearBounds()
    {
        this.maxOffsetX = Integer.MAX_VALUE;
        this.maxOffsetY = Integer.MAX_VALUE;
        this.minOffsetX = Integer.MIN_VALUE;
        this.minOffsetY = Integer.MIN_VALUE;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getMaxOffsetX()
    {
        return maxOffsetX;
    }

    public void setMaxOffsetX(int maxOffsetX)
    {
        this.maxOffsetX = maxOffsetX;
    }

    public int getMaxOffsetY()
    {
        return maxOffsetY;
    }

    public void setMaxOffsetY(int maxOffsetY)
    {
        this.maxOffsetY = maxOffsetY;
    }

    public int getMinOffsetX()
    {
        return minOffsetX;
    }

    public void setMinOffsetX(int minOffsetX)
    {
        this.minOffsetX = minOffsetX;
    }

    public int getMinOffsetY()
    {
        return minOffsetY;
    }

    public void setMinOffsetY(int minOffsetY)
    {
        this.minOffsetY = minOffsetY;
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
