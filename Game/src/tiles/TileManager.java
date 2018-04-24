package tiles;

import gfx.SpriteSheet;

public class TileManager
{
	private Tile[] tileList = new Tile[255];
	
	public TileManager(SpriteSheet spriteSheet)
	{		
		for(TileType t : TileType.values())
		{		
			tileList[t.ID] = new Tile(t, spriteSheet);
		}
	}
	
	public Tile getTile(int ID)
	{
		if(ID >= 0)
		{
			return tileList[ID];
		}
		else
		{
			return null;
		}
	}
	
	public int getTileFromColor(String color)
	{	
		int tile = -1;
		
		for(TileType t : TileType.values())
		{			
			if(t.mapColor.equals(color))
			{
				tile = t.ID;
				break;
			}
		}
		
		return tile;
	}
}
