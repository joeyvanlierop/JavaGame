package game;

import gfx.Renderer;
import gfx.SpriteSheet;
import gfx.Window;
import input.InputHandler;
import states.State;
import tiles.TileManager;

public final class GameManager
{
    public static int width;
    public static int height;

    private static Window window;
    private static Camera camera;
    private static Renderer renderer;
    private static InputHandler input;
    private static State state;

    public static GameLoop gameLoop;
    private static UpdateLoop updateLoop;
    private static RenderLoop renderLoop;

    public static void init(int width, int height, Camera camera, String... paths)
    {
        GameManager.width = width;
        GameManager.height = height;
        GameManager.camera = camera;

        for (String path : paths) {
            TileManager.loadTiles(new SpriteSheet(path));
        }

        renderer = new Renderer(camera);
        input = new InputHandler(renderer);
        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(60, updateLoop, renderLoop);
    }

    public static void start(State state)
    {
        GameManager.state = state;


        //Player player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, input, level);
        //enemy = new Blob(new SpriteSheet("/img/player(backup).png"), 300, 200, 0.5, level);
        //enemy.setTarget(player);
        window = new Window(width, height, renderer);
        //level.addEntity(player);
        //level.addEntity(enemy);
        //camera.init(player, level);

        updateLoop.addUpdatable(state);
        renderLoop.addRenderable(state);

        gameLoop.start();
    }

    public static Camera getCamera()
    {
        return camera;
    }

    public static InputHandler getInput()
    {
        return input;
    }
}