package scenes;

import entities.Entity;
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
    private ArrayList<Entity> entities = new ArrayList<>();
    private Camera camera;

    public Scene(TiledMap map)
    {
        this.map = map;
        this.camera = GameManager.getCamera();
    }

    public void onEnter()
    {

    }

    public void onExit()
    {

    }

    public void update()
    {
        for(Entity entity : entities)
        {
            entity.update();
        }
    }

    public void render(Renderer renderer)
    {
        map.render(renderer);

        for(Entity entity: entities)
        {
            entity.render(renderer);
        }
    }

    public void addEntity(Entity entity)
    {
        entities.add(entity);
    }
}
