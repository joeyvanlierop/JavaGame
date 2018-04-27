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
        double xMove = 0;
        double yMove = 0;

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
    protected boolean collision(double xMove, double yMove)
    {
        for(int corner = 0; corner < 4; corner++)
        {
            double xTile = (x + xMove) + corner % 2 * 15;
            double yTile = (y + yMove) + corner / 2 * 15;

            if(level.getTile((int) xTile, (int) yTile).isSolid())
            {
                return true;
            }
        }

        return false;
    }
}
