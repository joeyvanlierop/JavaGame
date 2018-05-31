package entities;

import components.Component;
import components.SpriteRenderer;
import components.Transform;
import gfx.Renderer;
import gfx.Sprite;
import game.IRenderable;
import game.IUpdatable;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 */
public abstract class GameObject implements IUpdatable, IRenderable {
    // TODO: Implement ID System
    //https://github.com/ClickerMonkey/Ents/blob/master/Java/src/org/magnos/entity/
    //https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013/
    protected final int id = 0;
    protected final String name;

    protected final Transform transform;
    protected final SpriteRenderer spriteRenderer;
    protected ArrayList<Component> components = new ArrayList<>();

    public GameObject(String name)
    {
        this.name = name;
        this.transform = new Transform();

        this.components.add(transform);
    }

    public GameObject(String name, double x, double y)
    {
        this.name = name;
        this.transform = new Transform(x, y);

        this.addComponent(transform);
    }

    public GameObject(String name, Sprite sprite, double x, double y)
    {
        this.name = name;
        this.transform = new Transform();
        this.spriteRenderer = new SpriteRenderer(sprite);

        this.addComponent(transform, spriteRenderer);
        //this.sprite = sprite;
    }

    public void update()
    {
        for(Component component : components)
        {
            component.update();
        }
    }

    public void render(Renderer renderer)
    {
        for(Component component : components)
        {
            component.render(renderer);
        }
        //renderer.renderSprite(sprite, (int) x, (int) y);
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

    public Component getComponent(Class returnType)
    {
        for(Component component : components)
        {
            if(component.getClass() == returnType)
            {
                return component;
            }
        }

        return null;
    }

    public Transform getTransform()
    {
        return transform;
    }

    public SpriteRenderer getSpriteRenderer ()
    {
        return spriteRenderer;
    }
}
