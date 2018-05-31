package entities;

import gfx.Sprite;
import level.TiledMap;

public abstract class MobileGameObject extends CollisionGameObject {
    protected int dir = 0;
    protected double moveSpeed;
    protected TiledMap level;

    public MobileGameObject(String name, Sprite sprite, double x, double y, double moveSpeed, TiledMap map)
    {
        super(name, sprite, x, y);

        this.moveSpeed = moveSpeed;
        this.level = map;
    }

    // https://github.com/vanZeben/2D-Game-Engine/blob/master/src/ca/vanzeben/game/entities/Mob.java
    // https://www.youtube.com/watch?v=Msd953YEZhg
    // https://www.youtube.com/watch?v=XugjVIOhXBE
    protected void move(double xMove, double yMove)
    {
        if (xMove != 0 && yMove != 0) {
            move(xMove, 0);
            move(0, yMove);

            return;
        }

        while (xMove != 0) {
            if (Math.abs(xMove) > 1) {
                if (!collision(abs(xMove), yMove)) {
                    this.x += abs(xMove);
                }

                xMove -= abs(xMove);
            } else {
                if (!collision(abs(xMove), yMove)) {
                    this.x += xMove;
                }

                xMove = 0;
            }
        }

        while (yMove != 0) {
            if (Math.abs(yMove) > 1) {
                if (!collision(xMove, abs(yMove))) {
                    this.y += abs(yMove);
                }

                yMove -= abs(yMove);
            } else {
                if (!collision(xMove, abs(yMove))) {
                    this.y += yMove;
                }

                yMove = 0;
            }
        }
    }

    protected boolean collision(double xMove, double yMove)
    {
        for (int corner = 0; corner < 4; corner++) {
            double xTile = (x + xMove) + corner % 2 * (sprite.getWidth() - 1);
            double yTile = (y + yMove) + corner / 2 * (sprite.getHeight() - 1);

            /*if (level.getTile((int) xTile, (int) yTile).isSolid())
            {
                return true;
            }*/

            if(level.isSolid((int) xTile, (int) yTile))
            {
                return true;
            }
        }

        return false;
    }

    protected int abs(double i)
    {
        if (i < 0)
            return -1;

        return 1;
    }
}