package level;

import entities.EntityManager;
import entities.components.CameraComponent;
import entities.components.PositionComponent;
import game.Camera;
import game.GameManager;
import gfx.Renderer;
import game.IRenderable;
import tiles.TileManager;

import java.util.ArrayList;

public class TiledMap implements IRenderable
{
    private int width;
    private int height;
    private TileManager tileManager;
    private ArrayList<TiledMapLayer> mapLayers;
    CameraComponent camera;

    public TiledMap(long width, long height, TileManager tileManager, ArrayList mapLayers)
    {
        this.width = (int) width;
        this.height = (int) height;
        this.mapLayers = mapLayers;
        this.tileManager = tileManager;
        camera = (CameraComponent) EntityManager.getComponent(GameManager.getCamera(), CameraComponent.class);
    }

    public void render(Renderer renderer)
    {
        int yBoundMin = Math.max(0, camera.getY() / 16);
        int yBoundMax = Math.min(height, ((camera.getY() + camera.getViewportHeight()) / 16 + 1));
        int xBoundMin = Math.max(0, camera.getX() / 16);
        int xBoundMax = Math.min(width, ((camera.getX() + camera.getViewportWidth()) / 16 + 1));

        for (int y = yBoundMin; y < yBoundMax; y++) {
            for (int x = xBoundMin; x < xBoundMax; x++) {
                for(TiledMapLayer layer : mapLayers)
                {
                    int spriteIndex = layer.getTile(x + y * width) - 1;

                    if(spriteIndex >= 0)
                    {
                        renderer.renderSprite(tileManager.getTile(spriteIndex).getSprite(), x * 16, y * 16);
                    }
                }
            }
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isSolid(int x, int y)
    {
        x /= 16;
        y /= 16;

        for(TiledMapLayer layer : mapLayers)
        {
            int spriteIndex = layer.getTile(x + y * width) - 1;

            if(spriteIndex >= 0)
            {
                if(tileManager.getTile(spriteIndex).isSolid())
                {
                    return true;
                }
            }
        }

        return false;
    }
}
