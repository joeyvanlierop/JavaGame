package entities;

import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;

public class Player extends Mob {
    private KeyHandler input;

    public Player(double x, double y, double moveSpeed, SpriteSheet spriteSheet, KeyHandler input, Level level)
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
            yMove -= moveSpeed;
        }

        if (input.down.isPressed()) {
            yMove += moveSpeed;
        }

        if (input.left.isPressed()) {
            xMove -= moveSpeed;
        }

        if (input.right.isPressed()) {
            xMove += moveSpeed;
        }

        if (xMove != 0 || yMove != 0) {
            move(xMove, yMove);
        }
    }

    @Override
    //https://www.youtube.com/watch?v=Msd953YEZhg
    protected boolean collision(int xMove, int yMove)
    {
        for(int corner = 0; corner < 4; corner++)
        {
            double xTile = (x + xMove) + corner % 2 * 15;
            double yTile = (y + yMove) + corner / 2 * 15;

            int ix = (int) Math.ceil(xTile);
            int iy = (int) Math.ceil(yTile);

            if(corner % 2 == 0)
                ix = (int) Math.floor(xTile);
            if(corner / 2 == 0)
                iy = (int) Math.floor(yTile);

            if(level.getTile(ix, iy).isSolid())
            {
                return true;
            }
        }

        return false;
    }
}
