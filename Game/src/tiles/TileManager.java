package tiles;

import java.util.ArrayList;

public class TileManager
{
    private ArrayList<Tile> tiles;

    public TileManager(ArrayList<Tile> tiles)
    {
        this.tiles = tiles;
    }

    public Tile getTile(int index)
    {
        return tiles.get(index);
    }
}
