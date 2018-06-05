package scenes;

import entities.System;
import gfx.Renderer;
import level.TiledMap;

import java.util.ArrayList;

public class Scene implements IScene
{
    //http://lspiroengine.com/?p=351
    //http://www.java-gaming.org/index.php/topic,30912

    private TiledMap map;
    private ArrayList<System> systems = new ArrayList<>();

    public Scene(TiledMap map)
    {
        this.map = map;
    }

    public void addSystem(System system)
    {
        systems.add(system);
    }

    public void onEnter()
    {

    }

    public void onExit()
    {

    }

    public void update()
    {
        for(System system : systems)
        {
            system.update();
        }
    }

    public void render(Renderer renderer)
    {
        map.render(renderer);

        for(System system : systems)
        {
            system.render(renderer);
        }
    }
}
