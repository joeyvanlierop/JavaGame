package level;

public class TiledMapLayer
{
    private int width;
    private int height;
    private int[] tiles;

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
