package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import game.Camera;
import game.Global;

public class Renderer
{
	private int[] pixels;
	
	private Camera camera;
	
	private BufferedImage view;
		
	public Renderer(Camera player)
	{		
		this.camera = player;
		
		this.view = new BufferedImage(Global.WIDTH, Global.HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
	}
	
	public void clearScreen(int color)
	{
		for (int pixelIndex = 0; pixelIndex < pixels.length; pixelIndex++)
		{
			pixels[pixelIndex] = color;
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(view, 0, 0, Global.WIDTH, Global.HEIGHT, null);
		g.dispose();
	}
	
	public void renderPixel(double x, double y, int color)
	{	
		if(x >= 0 && x < Global.WIDTH)
		{			
			double pixelIndex = x + y * Global.WIDTH;
			
			if(color != 0xffff00ff)
			{
				if(pixelIndex < pixels.length && pixelIndex >= 0)
				{
					pixels[(int) pixelIndex] = color;
				}
			}
		}
	}
	
	public void renderSprite(int spritePixels[], double xPosition, double yPosition, int spriteWidth, int spriteHeight)
	{
		for(int y = 0; y < spriteHeight; y++)
		{
			for(int x = 0; x < spriteWidth; x++)
			{	
				/*for(int yZoom = 0; yZoom < Global.zoom; yZoom++)
				{
					for(int xZoom = 0; xZoom < Global.zoom; xZoom++)
					{
						renderPixel((x * Global.zoom) + (xPosition * Global.zoom) + xZoom - camera.getX(),
									(y * Global.zoom) + (yPosition * Global.zoom) + yZoom - camera.getY(),
									spritePixels[x + y * spriteWidth]);
					}
				}*/
				
				renderPixel(x + xPosition - camera.getX(),
							y + yPosition - camera.getY(),
							spritePixels[x + y * spriteWidth]);
			}
		}
	}
}
