package scenes;

import gfx.Renderer;
import interfaces.IRenderable;
import interfaces.IUpdatable;

import java.util.Stack;

public class SceneManager implements IUpdatable, IRenderable
{
    private Stack<IScene> IScenes = new Stack<>();

    public void tick()
    {
        if(!IScenes.empty())
        {
            IScenes.peek().tick();
        }
    }

    public void render(Renderer renderer)
    {
        if(!IScenes.empty())
        {
            IScenes.peek().render(renderer);
        }
    }

    public void addScene(IScene IScene)
    {
        IScenes.push(IScene);
    }
}
