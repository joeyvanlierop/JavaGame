package game;

import entities.Blob;
import entities.Player;
import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;
import tiles.TileManager;

public class GameManager {
    private static final long serialVersionUID = 1L;

    private static Window window;
    public static int width = 600;
    public static int height = 600;

    private Player player;
    private Blob enemy;
    private Camera camera;
    public Renderer renderer;
    private TileManager tm;
    private KeyHandler input;
    private Level level;
    private UpdateLoop updateLoop;
    private RenderLoop renderLoop;
    public GameLoop gameLoop;

    public static void main(String[] args)
    {
        new GameManager();
    }

    public GameManager()
    {
        camera = new Camera(300, 300);
        tm = new TileManager(new SpriteSheet("/img/tile_sheet.png"));
        level = new Level("/levels/level_01.png", tm, camera);
        renderer = new Renderer(camera);
        window = new Window(width, height, renderer);
        input = new KeyHandler(renderer);
        player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, input, level);
        enemy = new Blob(new SpriteSheet("/img/player(backup).png"), 300, 200, 0.5, level);
        enemy.setTarget(player);

        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(60, updateLoop, renderLoop);

        level.addEntity(player);
        level.addEntity(enemy);
        camera.init(player, level);

        updateLoop.addUpdatable(level);
        renderLoop.addRenderable(level);

        gameLoop.start();
    }
}