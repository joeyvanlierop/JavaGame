package scenes;

import entities.Entity;
import game.Camera;
import gfx.Renderer;
import level.TiledMap;

public class GameScene extends Scene
{
    private TiledMap map;
    private Camera camera;
    private Entity player;

    public GameScene(TiledMap map, Camera camera, Entity player)
    {
        this.camera = camera;
        this.player = player;
        this.map = map;
        this.map.addEntity(player);

        this.camera.init(player, map);
    }

    public void init()
    {

    }

    public void tick()
    {
        map.tick();
    }

    public void render(Renderer renderer)
    {
        map.render(renderer);
    }
}
