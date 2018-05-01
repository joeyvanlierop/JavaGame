package gfx;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet
{

    private BufferedImage image;

    private int width;
    private int height;
    private int[] pixels;

    public SpriteSheet(String path)
    {
        try
        {
            this.image = ImageIO.read(Game.class.getResource(path));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        if (image == null)
        {
            return;
        }

        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = new int[width * height];

        this.image.getRGB(0, 0, width, height, pixels, 0, width);
    }

    public int[] getSprite(int xOffset, int yOffset, int spriteWidth, int spriteHeight)
    {
        int[] spritePixels = new int[spriteWidth * spriteHeight];

        for (int y = 0; y < spriteHeight; y++)
        {
            for (int x = 0; x < spriteWidth; x++)
            {
                spritePixels[x + y * spriteWidth] = getPixel(x + xOffset, y + yOffset);
            }
        }

        return spritePixels;
    }

    public int getPixel(int x, int y)
    {
        if (x < 0 || x >= width || y < 0 || y >= height)
        {
            return 0xff00ff;
        }

        return pixels[x + y * width];
    }
}