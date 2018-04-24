package tiles;

public enum TileType
{

	Grass(0, 0, "ff00ff00", false),
	Dirt(16, 0, "ffb97a57", false),
	Water(0, 16, "ff0000ff", false),
	Stone(16, 16, "ff000000", true);
	
	public final int ID;
	public final int x;
	public final int y;
	public final String mapColor;
	public final boolean collide;
	
	TileType(int x, int y, String mapColor, boolean collide)
	{
		this.ID = this.ordinal();
		this.x = x;
		this.y = y;
		this.mapColor = mapColor;
		this.collide = collide;
	}
	
	
}
