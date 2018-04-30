package gfx;

public class Sprite
{
    private int width;
    private int height;
    private int[] pixels;

    public Sprite(int x, int y, int width, int height, SpriteSheet spriteSheet)
    {
        this.width = width;
        this.height = height;
        this.pixels = spriteSheet.getSprite(x, y, width, height);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[] getPixels()
    {
        return pixels;
    }
}
