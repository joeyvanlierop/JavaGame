package entities;

import gfx.Sprite;
import gfx.SpriteSheet;
import level.Level;

public abstract class Enemy extends Mob
{
    protected Entity target = null;

    public Enemy(String name, double x, double y, double moveSpeed, SpriteSheet sheet , Level level)
    {
        super(name, x, y, new Sprite(16, 0, 16, 16, sheet), moveSpeed, level);
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