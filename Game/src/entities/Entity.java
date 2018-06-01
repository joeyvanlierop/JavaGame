package entities;

import components.Transform;
import game.IRenderable;
import game.IUpdatable;

import java.util.ArrayList;

/**
 *
 */
public class Entity
{
    // TODO: Implement ID System
    //https://github.com/JamesMcMahon/entitas-2d-roguelike/blob/master/Assets/Sources/Features/Input/InputSystem.cs
    //https://github.com/ClickerMonkey/Ents/blob/master/Java/src/org/magnos/entity/
    //https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013/
    protected final int id = 0;

    protected ArrayList<Component> components = new ArrayList<>();

    public Entity(String name)
    {
        //this.id = TODO
    }

    public void addComponent(Component... newComponents)
    {
        for(Component newComponent : newComponents)
        {
            for (Component component : components)
            {
                if (newComponent.getClass() == component.getClass())
                {
                    return;
                }
            }

            components.add(newComponent);
        }
    }

    public boolean hasComponent(Class<? extends Component>... componentTypes)
    {
        for(Component component : components)
        {
            for(Class<? extends Component> componentType : componentTypes)
            {
                if(!components.contains(componentType))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
