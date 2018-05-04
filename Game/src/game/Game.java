package game;

import entities.Player;
import gfx.SpriteSheet;
import input.KeyHandler;
import level.Level;
import tiles.TileManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {
    private static final long serialVersionUID = 1L;

    private static Window window;
    public static int width = 600;
    public static int height = 600;

    private Player player;
    //private Blob enemy;
    private Camera camera;
    private RenderHandler renderHandler;
    private TileManager tm;
    private KeyHandler input;
    private Level level;
    public UpdateHandler uh;

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
        renderHandler = new RenderHandler(camera);
        uh = new UpdateHandler(60, this);
        uh.addUpdatable(player);
        level.addEntity(player);

        //enemy.setTarget(player);
    }
}
