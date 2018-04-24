package entities;

import gfx.Renderer;
import gfx.SpriteSheet;

public abstract class Entity {
    protected String name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int[] sprite;

    public Entity(String name, int x, int y, SpriteSheet spriteSheet, int spriteX, int spriteY, int width, int height)
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
        renderer.renderSprite(sprite, x - width / 2, y - height / 2, width, height);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
