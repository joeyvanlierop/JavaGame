package entities;

import gfx.Sprite;
import entities.interfaces.CollisionInfo;

import java.awt.geom.Rectangle2D;

public abstract class CollisionGameObject extends GameObject {
    private int collisionBoxWidth;
    private int collisionBoxHeight;

    public CollisionGameObject(String name, Sprite sprite, double x, double y)
    {
        super(name, sprite, x, y);

        CollisionInfo info = this.getClass().getAnnotation(CollisionInfo.class);

        this.collisionBoxWidth = info.collisionBoxWidth();
        this.collisionBoxHeight = info.collisionBoxHeight();
    }

    public Rectangle2D getCollisionBox()
    {
        return new Rectangle2D.Double(x, y, collisionBoxWidth, collisionBoxHeight);
    }
}