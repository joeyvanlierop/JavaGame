package scenes;

import entities.GameObject;
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
    private ArrayList<GameObject> entities = new ArrayList<>();
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
        for(GameObject gameObject : entities)
        {
            gameObject.update();
        }
    }

    public void render(Renderer renderer)
    {
        map.render(renderer);

        for(GameObject gameObject : entities)
        {
            gameObject.render(renderer);
        }
    }

    public void addEntity(GameObject gameObject)
    {
        entities.add(gameObject);
    }
}
