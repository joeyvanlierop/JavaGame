package entities;

import gfx.Sprite;
import level.Level;

public abstract class Enemy extends MobileEntity {
    protected Entity target = null;

    public Enemy(String name, Sprite sprite, double x, double y, double moveSpeed, Level level)
    {
        super(name, sprite, x, y, moveSpeed, level);
    }

    public void tick()
    {
        target();
    }

    public void setTarget(Entity target)
    {
        this.target = target;
    }

    public abstract void target();
}