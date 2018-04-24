package game;

import entities.Entity;
import entities.Player;

public class Camera
{
	private int maxOffsetX;
	private int maxOffsetY;
	private int minOffsetX;
	private int minOffsetY;
	
	private Entity target;
	
	public Camera(int maxOffsetX, int maxOffsetY, Player target)
	{
		this.maxOffsetX = maxOffsetX;
		this.maxOffsetY = maxOffsetY;
		this.minOffsetX = 0;
		this.minOffsetY = 0;
		
		this.target = target;
	}
	
	public double getX()
	{
		double camX = target.getX() - Global.WIDTH / 2;
		
		if(camX > maxOffsetX)
			return maxOffsetX;
		
		if(camX < minOffsetX)
			return minOffsetX;
		
		return camX;
	}
	
	public double getY()
	{
		double camY = target.getY() - Global.HEIGHT / 2;
		
		if(camY > maxOffsetY)
			return maxOffsetY;
		
		if(camY < minOffsetY)
			return minOffsetY;
		
		return camY;
	}
}
