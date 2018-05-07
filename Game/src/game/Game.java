package game;

import entities.Player;
import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;
import tiles.TileManager;

public class Game {
    private static final long serialVersionUID = 1L;

    private static Window window;
    public static int width = 600;
    public static int height = 600;

    private Player player;
    //private Blob enemy;
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
        window = new Window(width, height, new Game());
    }

    public Game()
    {
        //enemy = new Blob(new SpriteSheet("/img/player(backup).png"), 300, 200, 0.5, level);

        tm = new TileManager(new SpriteSheet("/img/tile_sheet.png"));
        camera = new Camera(300, 300);
        level = new Level("/levels/level_01.png", tm, camera);
        renderer = new Renderer(camera);
        input = new KeyHandler(renderer);
        player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, input, level);

        updateLoop = new UpdateLoop();
        renderLoop = new RenderLoop(renderer);
        gameLoop = new GameLoop(60, updateLoop, renderLoop);

        level.addEntity(player);
        camera.init(player, level);

        updateLoop.addUpdatable(level);
        renderLoop.addRenderable(level);
        //enemy.setTarget(player);
    }

    public void start()
    {
        gameLoop.start();
    }
}