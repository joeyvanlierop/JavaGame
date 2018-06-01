package entities;

import gfx.Sprite;
import level.TiledMap;

public abstract class Enemy extends MobileEntity
{
    protected Entity target = null;

    public Enemy(String name, Sprite sprite, double x, double y, double moveSpeed, TiledMap map)
    {
        super(name, sprite, x, y, moveSpeed, map);
    }

    public void update()
    {
        target();
    }

    public void setTarget(Entity target)
    {
        this.target = target;
    }

    public abstract void target();
}