package tiles;

import gfx.Sprite;

public class Tile
{
    private int id;
    private boolean solid;
    private Sprite sprite;

    public Tile(int id, boolean solid, Sprite sprite)
    {
        this.id = id;
        this.solid = solid;
        this.sprite = sprite;
    }

    public int getId()
    {
        return id;
    }

    public boolean isSolid()
    {
        return solid;
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
