package entities.components;

import entities.Component;

public class PositionComponent extends Component
{
    private double x;
    private double y;

    public PositionComponent()
    {
        this(0, 0);
    }

    public PositionComponent(double x, double y)
    {
        super();

        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
