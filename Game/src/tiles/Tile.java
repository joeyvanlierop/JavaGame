package tiles;

import gfx.Renderer;
import gfx.SpriteSheet;

public class Tile
{
	public static int TILESIZE = 16;
	
	private TileType tileType;
	private SpriteSheet spriteSheet;
	
	public Tile(TileType tileType, SpriteSheet spriteSheet)
	{
		this.tileType = tileType;
		this.spriteSheet = spriteSheet;
	}
	
	public void renderTile(Renderer renderer, int xPosition, int yPosition)
	{		
		renderer.renderSprite(spriteSheet.getSprite(tileType.x, tileType.y, TILESIZE, TILESIZE), xPosition, yPosition, TILESIZE, TILESIZE);
	}

	public boolean canCollide()
	{	
		return tileType.collide;
	}
	
	@Override
    public String toString()
	{
		return this.tileType.name();
    }
}
