package game;

import gfx.Renderer;
import gfx.Window;
import input.InputHandler;
import scenes.Scene;
import scenes.SceneManager;

public abstract class GameManager
{
    private static GameConfiguration gameConfiguration = new GameConfiguration();

    private static Window window;
    private static Camera camera;
    private static Renderer renderer;
    private static InputHandler inputHandler;
    private static SceneManager sceneManager;

    public static GameLoop gameLoop;
    private static UpdateLoop updateLoop;
    private static RenderLoop renderLoop;

    public static void init(String... paths)
    {
        camera = new Camera((int) Math.ceil((double) gameConfiguration.getWidth() / gameConfiguration.getRenderScale()),
                            (int) Math.ceil((double) gameConfiguration.getHeight() / gameConfiguration.getRenderScale()));
        renderer = new Renderer(camera);
        inputHandler = new InputHandler(renderer);
        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(gameConfiguration.getUPS(), updateLoop, renderLoop);
        sceneManager = new SceneManager();
    }

    public static void start(Scene scene)
    {
        sceneManager.addScene(scene);
        window = new Window(getConfiguration().getWidth(), gameConfiguration.getHeight(), renderer);

        updateLoop.addUpdatable(inputHandler);
        updateLoop.addUpdatable(sceneManager);
        renderLoop.addRenderable(sceneManager);
        gameLoop.start();
    }

    public static void stop()
    {
        gameLoop.stop();
    }

    public static Camera getCamera()
    {
        return camera;
    }

    public static InputHandler getInputHandler()
    {
        return inputHandler;
    }

    public static GameConfiguration getConfiguration()
    {
        return gameConfiguration;
    }

    public static void loadState(Scene scene)
    {
        if(scene != null)
        {
            //TODO
        }

        sceneManager.addScene(scene);
    }
}