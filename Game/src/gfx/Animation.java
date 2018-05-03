package gfx;

public class Animation {
    private int count = 0;
    private int index = 0;
    private int delay;
    private Sprite[] sprites;

    public Animation(int delay, Sprite... sprites)
    {
        this.delay = delay;
        this.sprites = new Sprite[sprites.length];

        for (int i = 0; i < sprites.length; i++) {
            this.sprites[i] = sprites[i];
        }
    }

    public Sprite playAnimation()
    {
        count++;

        if (count > delay) {
            if (index < sprites.length - 1) {
                index++;
            } else {
                index = 0;
            }

            count = 0;
        }

        return sprites[index];
    }
}
