package game;

import interfaces.IUpdatable;

import java.util.ArrayList;

public class UpdateLoop {
    private ArrayList<IUpdatable> updatables;

    public UpdateLoop()
    {
        this.updatables = new ArrayList<>();
    }

    public void addUpdatable(IUpdatable updatable)
    {
        updatables.add(updatable);
    }

    public void tick()
    {
        for (IUpdatable updatable : updatables) {
            updatable.tick();
        }
    }
}