package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import entities.Player;
import gfx.Renderer;
import gfx.SpriteSheet;
import input.InputHandler;
import level.Level;
import tiles.Tile;
import tiles.TileManager;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 150389639316477052L;
	
	private Player player;
	private Camera camera;
	private Renderer renderer;
	private TileManager tm;
	private InputHandler input;
	private Level level;
		
	private boolean running = false;
	private Thread thread;
	
	public static void main(String[] args)
	{
		new Window(Global.WIDTH, Global.HEIGHT, new Game());
	}
	
	public Game()
	{
		input = new InputHandler(this);
		tm = new TileManager(new SpriteSheet("/img/tile_sheet.png"));
		level = new Level("/levels/level_01.png", tm);
		player = new Player(250, 250, 2, new SpriteSheet("/img/player.png"), input, level);
		camera = new Camera(level.getWidth() * Tile.TILESIZE - Global.WIDTH,
							level.getWidth() * Tile.TILESIZE - Global.HEIGHT,
							player);
		renderer = new Renderer(camera);
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{	
		final double UPS = 60.0;
		final double UPS_NS = 1000000000.0 / UPS;
		
		double deltaTime = 0;
		long currentTime = System.nanoTime();
		long lastTime = currentTime;
		long timer = System.currentTimeMillis();
		
		int frames = 0;
		int updates = 0;
		
		while(running)
		{
			currentTime = System.nanoTime();
			deltaTime += (currentTime - lastTime) / UPS_NS;
			lastTime = currentTime;

			while(deltaTime >= 1.0)
			{
				tick();
				updates++;
				deltaTime -= 1.0;
			}
			
			render();
			frames++;
						
			if(System.currentTimeMillis() - timer > 1000)
			{				
				timer += 1000;
				
				System.out.printf("FPS: %d, UPS: %d\n", frames, updates);
				//System.out.printf("Player X: %d, Tile X: %s\n", player.getX() / 16, level.getTile(player.getX(), player.getY()).toString());

				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		renderer.clearScreen(0x0000ccff);
		
		level.render(renderer, camera);
		player.render(renderer);

		renderer.render(g);
		
		bs.show();
	}
	
	public void tick()
	{		
		player.tick();
		
	}
}
