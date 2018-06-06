package entities.components;

import entities.Component;

public class MovementComponent extends Component
{
    private int xMove = 0;
    private int yMove = 0;
    private double speed;

    public MovementComponent()
    {
        this(1);
    }

    public MovementComponent(double speed)
    {
        super();

        this.speed = speed;
    }

    public int getXMove()
    {
        return xMove;
    }

    public void setXMove(int xMove)
    {
        this.xMove = xMove;
    }

    public int getYMove()
    {
        return yMove;
    }

    public void setYMove(int yMove)
    {
        this.yMove = yMove;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
