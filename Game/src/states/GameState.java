package states;

import entities.Entity;
import game.Camera;
import gfx.Renderer;
import level.Level;

public class GameState extends State
{
    private Level level;
    private Camera camera;
    private Entity player;

    public GameState(Level level, Camera camera, Entity player)
    {
        this.camera = camera;
        this.player = player;
        this.level = level;
        this.level.addEntity(player);

        this.camera.init(player, level);
    }

    public void tick()
    {
        level.tick();
    }

    public void render(Renderer renderer)
    {
        level.render(renderer);
    }
}
