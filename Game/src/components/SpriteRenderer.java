package components;

import entities.Component;
import gfx.Renderer;
import gfx.Sprite;

public class SpriteRenderer extends Component
{
    private int width;
    private int height;
    private Sprite sprite;

    public SpriteRenderer(Sprite sprite)
    {
        this.width = sprite.getWidth();
        this.height = sprite.getHeight();
        this.sprite = sprite;
    }

    public void render(Renderer renderer, int x, int y)
    {
        renderer.renderSprite(sprite, x, y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
