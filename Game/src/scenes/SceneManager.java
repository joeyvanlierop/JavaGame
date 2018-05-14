package scenes;

import gfx.Renderer;
import interfaces.IRenderable;
import interfaces.IUpdatable;

import java.util.Stack;

public class SceneManager implements IUpdatable, IRenderable
{
    private Stack<Scene> scenes;

    public SceneManager()
    {
        scenes = new Stack<>();
    }

    public void tick()
    {
        if(!scenes.empty())
        {
            scenes.peek().tick();
        }
    }

    public void render(Renderer renderer)
    {
        if(!scenes.empty())
        {
            scenes.peek().render(renderer);
        }
    }

    public void addScene(Scene scene)
    {
        scenes.push(scene);
    }
}
