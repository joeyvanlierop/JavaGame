package entities;

import gfx.SpriteSheet;
import level.Level;

public abstract class Mob extends Entity {
    protected double moveSpeed;
    protected Level level;

    public Mob(String name, double x, double y, SpriteSheet spriteSheet, int spriteX, int spriteY, int width, int height, double moveSpeed, Level level)
    {
        super(name, x, y, spriteSheet, spriteX, spriteY, width, height);

        this.moveSpeed = moveSpeed;
        this.level = level;
    }

    // https://github.com/vanZeben/2D-Game-Engine/blob/master/src/ca/vanzeben/game/entities/Mob.java
    protected void move(int xMove, int yMove)
    {
        if (xMove != 0 && yMove != 0) {
            move(xMove, 0);
            move(0, yMove);

            return;
        }

        //TODO: HOLY FUCK ITS ALL BROKEN

        for(int xi = 0; xi < xMove; xi++) {
            if (!collision(xi, yMove)) {
                this.x ++;
            }
        }

        for(int yi = 0; yi < xMove; y++) {
            if (!collision(xMove, yi)) {
                this.y ++;
            }
        }
    }

    protected abstract boolean collision(int xMove, int yMove);
}
