package entities;

import gfx.SpriteSheet;
import input.InputHandler;
import level.Level;

public class Player extends Mob
{	
	private InputHandler input;
	
	public Player(int x, int y, double moveSpeed, SpriteSheet spriteSheet, InputHandler input, Level level)
	{
		super("Player", x, y, spriteSheet, 16, 16, 16, 16, moveSpeed, level);
		
		this.input = input;
	}

	public void tick()
	{
		movePlayer();
	}
	
	@Override
	protected boolean hasCollided(int xMove, int yMove)
	{	
		int xNext = (int) (xMove * moveSpeed) + 16;
		int yNext = (int) (yMove * moveSpeed) + 16;
		
		return isSolidTile(xNext, yNext);
	}
	
	private void movePlayer()
	{
		int xMove = 0;
		int yMove = 0;
		
		if(input.up.isPressed())
		{
			yMove--;
		}
		
		if(input.down.isPressed())
		{
			yMove++;
		}
		
		if(input.left.isPressed())
		{
			xMove--;
		}
		
		if(input.right.isPressed())
		{
			xMove++;
		}
		
		if(xMove != 0 || yMove != 0)
		{
			move(xMove, yMove);
		}
	}
}
