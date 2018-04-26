package entities;

import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;

public class Player extends Mob {
    private KeyHandler input;

    public Player(int x, int y, int moveSpeed, SpriteSheet spriteSheet, KeyHandler input, Level level)
    {
        super("Player", x, y, spriteSheet, 16, 0, 16, 16, moveSpeed, level);

        this.input = input;
    }

    public void tick()
    {
        input();
    }

    private void input()
    {
        int xMove = 0;
        int yMove = 0;

        if (input.up.isPressed()) {
            yMove--;
        }

        if (input.down.isPressed()) {
            yMove++;
        }

        if (input.left.isPressed()) {
            xMove--;
        }

        if (input.right.isPressed()) {
            xMove++;
        }

        if (xMove != 0 || yMove != 0) {
            move(xMove, yMove);
        }
    }

    @Override
    protected boolean hasCollided(int xMove, int yMove)
    {
        int xMin = 0;
        int xMax = 15;
        int yMin = 0;
        int yMax = 15;

        for (int x = xMin; x <= xMax; x++)
        {
            if (isSolidTile(x, yMin, xMove, yMove)) {
                return true;
            }
        }

        for(int x = xMin; x <= xMax; x++)
        {
            if(isSolidTile(x, yMax, xMove, yMove))
            {
                return true;
            }
        }

        for (int y = yMin; y <= yMax; y++)
        {
            if (isSolidTile(xMin, y, xMove, yMove)) {
                return true;
            }
        }

        for(int y = yMin; y <= yMax; y++)
        {
            if(isSolidTile(xMax, y, xMove, yMove))
            {
                return true;
            }
        }

        return false;
    }
}
