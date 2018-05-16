package entities;

import input.Controls;
import interfaces.CollisionInfo;
import gfx.Animation;
import gfx.Sprite;
import gfx.SpriteSheet;
import input.InputHandler;
import level.TiledMap;

//@EntityInfo(TODO)
@CollisionInfo(collisionBoxWidth = 10, collisionBoxHeight = 10)
public class Player extends MobileEntity {
    private InputHandler input;

    private Animation idleUp;
    private Animation idleDown;
    private Animation idleLeft;
    private Animation idleRight;
    private Animation moveUp;
    private Animation moveDown;
    private Animation moveLeft;
    private Animation moveRight;

    private double xMove = 0;
    private double yMove = 0;

    public Player(SpriteSheet spriteSheet, double x, double y, double moveSpeed, InputHandler input, TiledMap map)
    {
        super("Player", new Sprite(0, 16, 13, 16, spriteSheet), x, y, moveSpeed, map);

        this.input = input;

        Sprite up0 = new Sprite(0, 0, 16, 16, spriteSheet);
        Sprite up1 = new Sprite(16, 0, 16, 16, spriteSheet);
        Sprite up2 = new Sprite(32, 0, 16, 16, spriteSheet);
        Sprite down0 = new Sprite(0, 16, 16, 16, spriteSheet);
        Sprite down1 = new Sprite(16, 16, 16, 16, spriteSheet);
        Sprite down2 = new Sprite(32, 16, 16, 16, spriteSheet);
        Sprite left0 = new Sprite(0, 32, 16, 16, spriteSheet);
        Sprite left1 = new Sprite(16, 32, 16, 16, spriteSheet);
        Sprite left2 = new Sprite(32, 32, 16, 16, spriteSheet);
        Sprite left3 = new Sprite(48, 32, 16, 16, spriteSheet);
        Sprite right0 = new Sprite(0, 48, 16, 16, spriteSheet);
        Sprite right1 = new Sprite(16, 48, 16, 16, spriteSheet);
        Sprite right2 = new Sprite(32, 48, 16, 16, spriteSheet);
        Sprite right3 = new Sprite(48, 48, 16, 16, spriteSheet);
        Sprite idleUp0 = new Sprite(0, 64, 16, 16, spriteSheet);
        Sprite idleUp1 = new Sprite(16, 64, 16, 16, spriteSheet);
        Sprite idleDown0 = new Sprite(0, 80, 16, 16, spriteSheet);
        Sprite idleDown1 = new Sprite(16, 80, 16, 16, spriteSheet);
        Sprite idleLeft0 = new Sprite(0, 96, 16, 16, spriteSheet);
        Sprite idleLeft1 = new Sprite(16, 96, 16, 16, spriteSheet);
        Sprite idleRight0 = new Sprite(0, 112, 16, 16, spriteSheet);
        Sprite idleRight1 = new Sprite(16, 112, 16, 16, spriteSheet);

        this.moveUp = new Animation(6, up0, up1, up0, up2);
        this.moveDown = new Animation(6, down0, down1, down0, down2);
        this.moveLeft = new Animation(3, left0, left1, left0, left2, left3, left2);
        this.moveRight = new Animation(3, right0, right1, right0, right2, right3, right2);
        this.idleUp = new Animation(20, idleUp0, idleUp1);
        this.idleDown = new Animation(20, idleDown0, idleDown1);
        this.idleLeft = new Animation(20, idleLeft0, idleLeft1);
        this.idleRight = new Animation(20, idleRight0, idleRight1);

        input.registerKey(Controls.UP.getKeyCode(), () ->
        {
            yMove -= moveSpeed;
            dir = 0;
        });

        input.registerKey(Controls.DOWN.getKeyCode(), () ->
        {
            yMove += moveSpeed;
            dir = 1;
        });

        input.registerKey(Controls.LEFT.getKeyCode(), () ->
        {
            xMove -= moveSpeed;
            dir = 2;
        });

        input.registerKey(Controls.RIGHT.getKeyCode(), () ->
        {
            xMove += moveSpeed;
            dir = 3;
        });
    }

    public void tick()
    {
        animate();
        input();
    }

    private void animate()
    {
        switch (dir) {
            case 0:
                sprite = moveUp.playAnimation();
                break;
            case 1:
                sprite = moveDown.playAnimation();
                break;
            case 2:
                sprite = moveLeft.playAnimation();
                break;
            case 3:
                sprite = moveRight.playAnimation();
                break;
            case 4:
                sprite = idleUp.playAnimation();
                break;
            case 5:
                sprite = idleDown.playAnimation();
                break;
            case 6:
                sprite = idleLeft.playAnimation();
                break;
            case 7:
                sprite = idleRight.playAnimation();
                break;
        }
    }

    private void input()
    {
        if (xMove != 0 || yMove != 0)
        {
            move(xMove, yMove);
        }
        else
        {
            switch (dir)
            {
                case 0:
                    dir = 4;
                    break;
                case 1:
                    dir = 5;
                    break;
                case 2:
                    dir = 6;
                    break;
                case 3:
                    dir = 7;
                    break;
            }
        }

        xMove = 0;
        yMove = 0;
    }
}
