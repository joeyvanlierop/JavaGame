package entities.components;

import entities.Component;

import java.util.ArrayList;

public class Prefab
{
    private ArrayList<Component> components = new ArrayList<>();

    /**
     * Creates A Prefab
     *
     * TODO: Add Parent Object Stuff
     */
    public Prefab()
    {

    }

    public Prefab add(Component component)
    {
        components.add(component);

        return this;
    }

    public ArrayList<Component> getComponents()
    {
        return components;
    }
}
