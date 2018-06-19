package game;

import events.EventManager;
import gfx.Renderer;
import gfx.Window;
import input.InputHandler;
import scenes.Scene;
import scenes.SceneManager;

public abstract class GameManager
{
    private static GameConfiguration gameConfiguration;

    private static Window window;
    private static Renderer renderer;
    private static EventManager eventManager;
    private static InputHandler inputHandler;
    private static SceneManager sceneManager;
    private static Camera camera;

    public static GameLoop gameLoop;
    private static UpdateLoop updateLoop;
    private static RenderLoop renderLoop;

    static
    {
        gameConfiguration = new GameConfiguration();
        inputHandler = new InputHandler();
        eventManager = new EventManager();
        sceneManager = new SceneManager();
    }

    public static void init()
    {
        camera = new Camera(gameConfiguration.getWidth() / gameConfiguration.getRenderScale(), gameConfiguration.getHeight() / gameConfiguration.getRenderScale());
        renderer = new Renderer();
        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(gameConfiguration.getUPS(), updateLoop, renderLoop);
        eventManager = new EventManager();
    }

    public static void start(Scene scene)
    {
        window = new Window(getConfiguration().getWidth(), gameConfiguration.getHeight(), renderer);

        sceneManager.addScene(scene);
        updateLoop.addUpdatable(inputHandler);
        updateLoop.addUpdatable(sceneManager);
        renderLoop.addRenderable(sceneManager);
        gameLoop.start();
    }

    public static void stop()
    {
        window.close();
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

    public static Window getWindow()
    {
        return window;
    }

    public static EventManager getEventManager()
    {
        return eventManager;
    }
}