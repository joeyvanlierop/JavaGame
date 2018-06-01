package entities.components;

import entities.Component;

public class HitPointsComponent extends Component
{
    private double hitPoints;

    public HitPointsComponent()
    {
        this(100);
    }

    public HitPointsComponent(double hitPoints)
    {
        super();

        this.hitPoints = hitPoints;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }
}
