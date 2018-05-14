package tiles;

public enum TileType {

    GRASS(0, 0, "ff00ff00", false),
    DIRT(6, 2, "ffb97a57", false),
    WATER(10, 0, "ff0000ff", false),
    STONE(9, 0, "ff000000", true);

    public final int ID;
    public final int x;
    public final int y;
    public final String mapColor;
    public boolean solid;

    TileType(int x, int y, String mapColor, boolean solid)
    {
        this.ID = this.ordinal();
        this.x = x;
        this.y = y;
        this.mapColor = mapColor;
        this.solid = solid;
    }
}
