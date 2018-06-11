package entities.components;

import entities.Component;
import level.TiledMap;

import java.util.UUID;

public class CameraComponent extends Component
{
    private int x = 0;
    private int y = 0;
    private int maxOffsetX;
    private int maxOffsetY;
    private int minOffsetX;
    private int minOffsetY;
    private int viewportWidth;
    private int viewportHeight;

    public CameraComponent(int viewportWidth, int viewportHeight)
    {
        this(0, 0, 0, 0, viewportWidth, viewportHeight);
    }

    public CameraComponent(int maxOffsetX, int maxOffsetY, int minOffsetX, int minOffsetY, int viewportWidth, int viewportHeight)
    {
        super();

        this.maxOffsetX = maxOffsetX;
        this.maxOffsetY = maxOffsetY;
        this.minOffsetX = minOffsetX;
        this.minOffsetY = minOffsetY;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMaxOffsetX() {
        return maxOffsetX;
    }

    public void setMaxOffsetX(int maxOffsetX) {
        this.maxOffsetX = maxOffsetX;
    }

    public int getMaxOffsetY() {
        return maxOffsetY;
    }

    public void setMaxOffsetY(int maxOffsetY) {
        this.maxOffsetY = maxOffsetY;
    }

    public int getMinOffsetX() {
        return minOffsetX;
    }

    public void setMinOffsetX(int minOffsetX) {
        this.minOffsetX = minOffsetX;
    }

    public int getMinOffsetY() {
        return minOffsetY;
    }

    public void setMinOffsetY(int minOffsetY) {
        this.minOffsetY = minOffsetY;
    }

    public int getViewportWidth() {
        return viewportWidth;
    }

    public void setViewportWidth(int viewportWidth) {
        this.viewportWidth = viewportWidth;
    }

    public int getViewportHeight() {
        return viewportHeight;
    }

    public void setViewportHeight(int viewportHeight) {
        this.viewportHeight = viewportHeight;
    }
}
