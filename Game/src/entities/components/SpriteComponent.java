package entities.components;

import entities.Component;
import gfx.Sprite;

public class SpriteComponent extends Component
{
    private Sprite sprite;

    public SpriteComponent(Sprite sprite)
    {
        super();

        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
