package level;

import entities.Entity;
import game.Camera;
import game.GameManager;
import gfx.Renderer;
import gfx.Sprite;
import gfx.SpriteSheet;
import interfaces.IRenderable;
import interfaces.IUpdatable;

import java.util.ArrayList;

public class TiledMap implements IRenderable, IUpdatable
{
    private Camera camera;

    private int width;
    private int height;
    private ArrayList<TiledMapLayer> mapLayers;
    private TiledMapLayer collisionLayer;
    private ArrayList<Sprite> sprites = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public TiledMap(long width, long height, SpriteSheet tileSet, ArrayList mapLayers)
    {
        this.width = (int) width;
        this.height = (int) height;
        this.mapLayers = mapLayers;
        this.camera = GameManager.getCamera();

        this.loadTiles(tileSet);
    }

    private void loadTiles(SpriteSheet tileSet)
    {
        for(int y = 0; y < tileSet.getHeight(); y += 16)
        {
            for(int x = 0; x < tileSet.getWidth(); x += 16)
            {
                sprites.add(new Sprite(x, y, 16, 16, tileSet));
            }
        }
    }

    public void render(Renderer renderer)
    {
        /*for(TiledMapLayer layer : mapLayers)
        {
            layer.render(renderer, camera);
        }*/

        int yBoundMin = Math.max(0, camera.getY() / 16);
        int yBoundMax = Math.min(height, ((camera.getY() + camera.getViewportHeight()) / 16 + 1));
        int xBoundMin = Math.max(0, camera.getX() / 16);
        int xBoundMax = Math.min(width, ((camera.getX() + camera.getViewportWidth()) / 16 + 1));

        for (int y = yBoundMin; y < yBoundMax; y++) {
            for (int x = xBoundMin; x < xBoundMax; x++) {
                /*for(TiledMapLayer layer : mapLayers)
                {*/
                    TiledMapLayer layer = mapLayers.get(0);

                    int spriteIndex = layer.getTile(x + y * width) - 1;

                    if(spriteIndex >= 0)
                    {
                        renderer.renderSprite(sprites.get(spriteIndex), x * 16, y * 16);
                    }
                //}
            }
        }

        for (Entity entity : entities)
        {
            entity.render(renderer);
        }
    }

    public void tick()
    {
        for (Entity entity : entities)
        {
            entity.tick();
        }
    }

    public void addEntity(Entity entity)
    {
        entities.add(entity);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
