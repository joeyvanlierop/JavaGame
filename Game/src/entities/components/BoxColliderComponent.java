package entities.components;

import entities.Component;

public class BoxColliderComponent extends Component
{
    private boolean trigger;

    public BoxColliderComponent()
    {
        this(false);
    }

    public BoxColliderComponent(boolean trigger)
    {
        super();

        this.trigger = trigger;
    }

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }
}
