package components;

import entities.Component;

public class Transform extends Component
{
    private double x;
    private double y;

    public Transform()
    {
        this.x = 0;
        this.y = 0;
    }

    public Transform(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
