package scenes;

import entities.Entity;
import game.Camera;
import game.GameManager;
import gfx.Renderer;
import level.Level;

import java.awt.event.KeyEvent;

public abstract class GameScene extends Scene
{
    private Level level;
    private Camera camera;
    private Entity player;

    public GameScene(Level level, Camera camera, Entity player)
    {
        this.camera = camera;
        this.player = player;
        this.level = level;
        this.level.addEntity(player);

        this.camera.init(player, level);
    }

    public void init()
    {

    }

    public void tick()
    {
        level.tick();

        if(GameManager.getInputHandler().getKey(KeyEvent.VK_ESCAPE))
        {
            GameManager.stop();
        }
    }

    public void render(Renderer renderer)
    {
        level.render(renderer);
    }
}
