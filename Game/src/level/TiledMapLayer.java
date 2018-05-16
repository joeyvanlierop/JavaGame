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

    /*public void render(Renderer renderer, Camera camera)
    {
        int yBoundMin = Math.max(0, camera.getY() / 16);
        int yBoundMax = Math.min(height, ((camera.getY() + camera.getViewportHeight()) / 16 + 1));
        int xBoundMin = Math.max(0, camera.getX() / 16);
        int xBoundMax = Math.min(width, ((camera.getX() + camera.getViewportWidth()) / 16 + 1));

        for (int y = yBoundMin; y < yBoundMax; y++) {
            for (int x = xBoundMin; x < xBoundMax; x++) {
                if (tiles[x + y * width] >= 0)
                {
                    int spriteIndex = tiles[x + y * width] - 1;

                    if(spriteIndex >= 0)
                    {
                        renderer.renderSprite(sprites.get(spriteIndex), x * 16, y * 16);
                    }
                }
            }
        }
    }*/

    public int getTile(int index)
    {
        return tiles[index];
    }
}
