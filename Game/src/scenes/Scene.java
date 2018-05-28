package scenes;

import entities.Entity;
import game.Camera;
import game.GameManager;
import gfx.Renderer;
import interfaces.IRenderable;
import interfaces.IUpdatable;
import level.TiledMap;

import java.util.ArrayList;

public class Scene implements IScene
{
    //http://lspiroengine.com/?p=351
    //http://www.java-gaming.org/index.php/topic,30912

    private ArrayList<IUpdatable> updateables = new ArrayList<>();
    private ArrayList<IRenderable> renderables = new ArrayList<>();
    private Camera camera;

    public Scene(TiledMap map)
    {
        this.updateables.add(map);
        this.renderables.add(map);
        this.camera = GameManager.getCamera();
    }

    public void load()
    {

    }

    public void unload()
    {

    }

    public void tick()
    {
        for(IUpdatable updatable : updateables)
        {
            updatable.tick();
        }
    }

    public void render(Renderer renderer)
    {
        for(IRenderable renderable : renderables)
        {
            renderable.render(renderer);
        }
    }
}
