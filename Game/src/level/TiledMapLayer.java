package level;

public class TiledMapLayer
{
    public int width;
    public int height;
    public int[] tiles;

    public TiledMapLayer(long width, long height, int[] tiles)
    {
        this.width = (int) width;
        this.height = (int) height;
        this.tiles = tiles;
    }

    public int getTile(int index)
    {
        return tiles[index];
    }
}
