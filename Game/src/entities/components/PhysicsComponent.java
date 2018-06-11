package entities.components;

import entities.Component;

public class PhysicsComponent extends Component
{
    private double mass;

    public PhysicsComponent(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
