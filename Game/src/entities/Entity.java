package entities;

import entities.interfaces.IUpdatable;
import game.RenderHandler;
import gfx.Sprite;

public abstract class Entity implements IUpdatable {
    protected String name;
    protected Sprite sprite;
    protected double x;
    protected double y;

    public Entity(String name, Sprite sprite, double x, double y)
    {
        super();
        this.name = name;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public void render(RenderHandler renderHandler)
    {
        renderHandler.renderSprite(sprite, (int) x, (int) y);
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }
}
