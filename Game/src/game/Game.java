package game;

import entities.Blob;
import entities.Player;
import gfx.Renderer;
import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;
import tiles.TileManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    private static Window window;
    public static int width = 600;
    public static int height = 600;

    private Player player;
    //private Blob enemy;
    private Camera camera;
    private Renderer renderer;
    private TileManager tm;
    private KeyHandler input;
    private Level level;

    private boolean running = false;
    private Thread thread;

    public static void main(String[] args)
    {
        window = new Window(width, height, new Game());
    }

    public Game()
    {
        input = new KeyHandler(this);
        tm = new TileManager(new SpriteSheet("/img/tile_sheet.png"));
        level = new Level("/levels/level_01.png", tm);
        player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, input, level);
        //enemy = new Blob(new SpriteSheet("/img/player(backup).png"), 300, 200, 0.5, level);
        camera = new Camera(level, player, 300, 300);
        renderer = new Renderer(camera);

        //nemy.setTarget(player);
    }

    public synchronized void start()
    {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        final double UPS = 60;
        final double UPS_NS = 1000000000 / UPS;

        double deltaTime = 0;
        long currentTime = System.nanoTime();
        long lastTime = currentTime;
        long timer = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (running) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / UPS_NS;
            lastTime = currentTime;

            while (deltaTime >= 1.0) {
                tick();
                updates++;
                deltaTime -= 1.0;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                window.setTitle(String.format("FPS: %d, UPS: %d\n", frames, updates));

                System.out.println(player.getCollisionBox().getBounds2D());

                frames = 0;
                updates = 0;
            }
        }
    }

    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        renderer.clearScreen(0x0000ccff);

        level.render(renderer, camera);
        player.render(renderer);
        //enemy.render(renderer);

        renderer.render(g);

        bs.show();
    }

    public void tick()
    {
        player.tick();
        //enemy.tick();
    }
}
