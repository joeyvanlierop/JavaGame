package scenes;

import gfx.Renderer;

public interface IScene
{
    void load();

    void unload();

    void tick();

    void render(Renderer renderer);
}
