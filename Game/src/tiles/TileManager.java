package tiles;

import gfx.SpriteSheet;

import java.util.ArrayList;

public final class TileManager {
    private static ArrayList<Tile> tileList = new ArrayList<>();

    public static void loadTiles(SpriteSheet spriteSheet)
    {
        for (TileType t : TileType.values()) {
            tileList.add(new Tile(t, spriteSheet));
        }
    }

    public static Tile getTile(int ID)
    {
        if (ID >= 0) {
            return tileList.get(ID);
        } else {
            return null;
        }
    }

    public static int getTileFromColor(String color)
    {
        int tile = -1;

        for (TileType t : TileType.values()) {
            if (t.mapColor.equals(color)) {
                tile = t.ID;
                break;
            }
        }

        return tile;
    }
}
