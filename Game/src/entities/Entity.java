package entities;

import gfx.Renderer;
import gfx.SpriteSheet;

public abstract class Entity {
    protected String name;
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected int[] sprite;

    public Entity(String name, double x, double y, SpriteSheet spriteSheet, int spriteX, int spriteY, int width, int height)
    {
        super();
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = spriteSheet.getSprite(spriteX, spriteY, width, height);
    }

    public abstract void tick();

    public void render(Renderer renderer)
    {
        renderer.renderSprite(sprite, (int) x, (int) y, width, height);
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
