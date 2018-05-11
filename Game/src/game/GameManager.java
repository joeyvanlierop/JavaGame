package game;

import gfx.Renderer;
import gfx.SpriteSheet;
import gfx.Window;
import input.InputHandler;
import states.State;
import tiles.TileManager;

public abstract class GameManager
{
    private static GameConfiguration gameConfiguration = new GameConfiguration();

    private static Window window;
    private static Camera camera;
    private static Renderer renderer;
    private static InputHandler input;
    private static State state;

    public static GameLoop gameLoop;
    private static UpdateLoop updateLoop;
    private static RenderLoop renderLoop;

    public static void init(String... paths)
    {
        //GameManager.width = gameConfiguration.getWidth();
        //GameManager.height = gameConfiguration.getHeight();

        for (String path : paths)
        {
            TileManager.loadTiles(new SpriteSheet(path));
        }

        camera = new Camera(gameConfiguration.getWidth() / gameConfiguration.getRenderScale(),
                            gameConfiguration.getHeight() / gameConfiguration.getRenderScale());
        renderer = new Renderer(camera);
        input = new InputHandler(renderer);
        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(gameConfiguration.getUPS(), updateLoop, renderLoop);
    }

    public static void start(State state)
    {
        GameManager.state = state;
        window = new Window(getConfiguration().getWidth(), gameConfiguration.getHeight(), renderer);

        updateLoop.addUpdatable(state);
        renderLoop.addRenderable(state);
        gameLoop.start();
        //Player player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, input, level);
        //enemy = new Blob(new SpriteSheet("/img/player(backup).png"), 300, 200, 0.5, level);
        //enemy.setTarget(player);
        //level.addEntity(player);
        //level.addEntity(enemy);
        //camera.init(player, level);
    }

    public static Camera getCamera()
    {
        return camera;
    }

    public static InputHandler getInput()
    {
        return input;
    }

    public static GameConfiguration getConfiguration()
    {
        return gameConfiguration;
    }

    public static void loadState(State state)
    {
        if(state != null)
        {
            //TODO
        }

        GameManager.state = state;
    }
}