package entities;

import gfx.SpriteSheet;
import level.Level;
import tiles.Tile;

public abstract class Mob extends Entity {
    protected int moveSpeed;
    protected Level level;

    public Mob(String name, int x, int y, SpriteSheet spriteSheet, int spriteX, int spriteY, int width, int height, int moveSpeed, Level level)
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

        if (!hasCollided(xMove, yMove)) {
            x += xMove * moveSpeed;
            y += yMove * moveSpeed;
        }
    }

    protected boolean isSolidTile(int xOffset, int yOffset, int xMove, int yMove)
    {
        Tile currentTile = level.getTile(x + xOffset, y + yOffset);
        Tile nextTile = level.getTile(x + xMove + xOffset, y + yMove + yOffset);

        if (currentTile != nextTile && nextTile.isSolid()) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract boolean hasCollided(int xMove, int yMove);
}
