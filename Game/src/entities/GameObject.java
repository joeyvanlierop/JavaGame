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
    protected String name;
    //protected Sprite sprite;

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

        this.components.add(transform);
    }

    public GameObject(String name, Sprite sprite, double x, double y)
    {
        this.name = name;
        this.transform = new Transform();
        this.spriteRenderer = new SpriteRenderer(sprite);

        this.components.add(transform);
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

    public void addComponent(Component newComponent)
    {
        for(Component component : components)
        {
            if(newComponent.getClass() == component.getClass())
            {
                return;
            }
        }

        components.add(newComponent);
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
