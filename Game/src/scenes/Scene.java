package scenes;

import entities.EntityManager;
import entities.System;
import entities.components.PositionComponent;
import entities.components.SpriteComponent;
import game.GameManager;
import gfx.Renderer;
import gfx.Sprite;
import level.TiledMap;
import level.TiledMapLayer;
import tiles.Tile;
import tiles.TileManager;

import java.util.ArrayList;
import java.util.UUID;

public class Scene
{
    //http://lspiroengine.com/?p=351
    //http://www.java-gaming.org/index.php/topic,30912

    private TiledMap map;
    private EntityManager entityManager;
    private ArrayList<System> systems = new ArrayList<>();

    public Scene(TiledMap map)
    {
        this.map = map;
        this.entityManager = new EntityManager();
        this.importMap(map);

        GameManager.getCamera().setBounds(map);
    }

    private void importMap(TiledMap map)
    {
        for(TiledMapLayer layer : map.mapLayers)
        {
            for(int y = 0; y < layer.height; y++)
            {
                for (int x = 0; x < layer.width; x++)
                {
                    int tileIndex = layer.getTile(x + y * layer.width) - 1;

                    if(tileIndex >= 0)
                    {
                        Tile tile = map.tileManager.getTile(tileIndex);

                        Sprite tileSprite = tile.getSprite();

                        UUID ID = entityManager.createEntity();

                        entityManager.addComponent(ID, new SpriteComponent(tileSprite));
                        entityManager.addComponent(ID, new PositionComponent(x * 16, y * 16));
                    }
                }
            }
        }
    }

    public void addSystem(System system)
    {
        systems.add(system);
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
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
            system.update(entityManager);
        }
    }

    public void render(Renderer renderer)
    {
        //map.render(renderer);

        for(System system : systems)
        {
            system.render(entityManager, renderer);
        }
    }
}
