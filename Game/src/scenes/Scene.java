package scenes;

import entities.EntitySystem;
import game.Camera;
import game.GameManager;
import gfx.Renderer;
import level.TiledMap;

import java.util.ArrayList;

public class Scene implements IScene
{
    //http://lspiroengine.com/?p=351
    //http://www.java-gaming.org/index.php/topic,30912

    private TiledMap map;
    private ArrayList<EntitySystem> entitySystems = new ArrayList<>();
    private Camera camera;

    public Scene(TiledMap map)
    {
        this.map = map;
        this.camera = GameManager.getCamera();
    }

    public void addSystem(EntitySystem system)
    {
        entitySystems.add(system);
    }

    public void onEnter()
    {

    }

    public void onExit()
    {

    }

    public void update()
    {
        for(EntitySystem entitySystem : entitySystems)
        {
            entitySystem.update();
        }
    }

    public void render(Renderer renderer)
    {
        map.render(renderer);

        for(EntitySystem entitySystem : entitySystems)
        {
            entitySystem.render(renderer);
        }
    }
}
