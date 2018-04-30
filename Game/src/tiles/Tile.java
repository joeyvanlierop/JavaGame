package tiles;

import gfx.Renderer;
import gfx.Sprite;
import gfx.SpriteSheet;

public class Tile
{
    public static int TILESIZE = 16;

    private TileType tileType;
    private Sprite sprite;

    public Tile(TileType tileType, SpriteSheet spriteSheet)
    {
        this.tileType = tileType;
        this.sprite = new Sprite(tileType.x * TILESIZE, tileType.y * TILESIZE, TILESIZE, TILESIZE, spriteSheet);
    }

    public void renderTile(Renderer renderer, int xPosition, int yPosition)
    {
        renderer.renderSprite(sprite, xPosition, yPosition);
    }

    public boolean isSolid()
    {
        return tileType.solid;
    }

    @Override
    public String toString()
    {
        return this.tileType.name();
    }
}
