package scenes;

import gfx.Renderer;
import game.IRenderable;
import game.IUpdatable;

import java.util.ArrayList;

public class SceneManager implements IUpdatable, IRenderable
{
    private ArrayList<Scene> scenes = new ArrayList<>();
    private int currentScene = 0;

    public void update()
    {
        if(!scenes.isEmpty())
        {
            scenes.get(currentScene).update();
        }
    }

    public void render(Renderer renderer)
    {
        if(!scenes.isEmpty())
        {
            scenes.get(currentScene).render(renderer);
        }
    }

    public void addScene(Scene IScene)
    {
        scenes.add(IScene);
    }

    public void loadScene(int sceneNumber)
    {
        currentScene = sceneNumber;
    }

    public Scene getCurrentScene()
    {
        return scenes.get(currentScene);
    }
}
