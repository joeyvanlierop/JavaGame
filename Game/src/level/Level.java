package level;

import game.Camera;
import game.Game;
import gfx.Renderer;
import tiles.Tile;
import tiles.TileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level {
    private BufferedImage image;
    private TileManager tm;

    private int width;
    private int height;
    private int[] tiles;

    public Level(String path, TileManager tm)
    {
        try {
            image = ImageIO.read(Game.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image == null) {
            return;
        }

        this.width = image.getWidth();
        this.height = image.getHeight();
        this.tiles = new int[width * height];
        this.tm = tm;

        this.loadLevel(image);
    }

    private void loadLevel(BufferedImage image)
    {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = tm.getTileFromColor(Integer.toHexString(image.getRGB(x, y)));
            }
        }
    }

    public void render(Renderer renderer, Camera camera)
    {

        int yBoundMin = Math.max(0, camera.getY() / Tile.TILESIZE);
        int yBoundMax = Math.min(height, ((camera.getY() + camera.getViewportHeight()) / Tile.TILESIZE + 1));
        int xBoundMin = Math.max(0, camera.getX() / Tile.TILESIZE);
        int xBoundMax = Math.min(width, ((camera.getX() + camera.getViewportWidth()) / Tile.TILESIZE + 1));

        for (int y = yBoundMin; y < yBoundMax; y++) {
            for (int x = xBoundMin; x < xBoundMax; x++) {
                if (tiles[x + y * width] >= 0) {
                    tm.getTile(tiles[x + y * width]).renderTile(renderer, x * 16, y * 16);
                }
            }
        }
    }

    public Tile getTile(int x, int y)
    {
        x /= Tile.TILESIZE;
        y /= Tile.TILESIZE;

        return tm.getTile(tiles[x + y * width]);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
