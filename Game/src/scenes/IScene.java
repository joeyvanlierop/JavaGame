package scenes;

import gfx.Renderer;
import game.IRenderable;
import game.IUpdatable;

public interface IScene extends IRenderable, IUpdatable
{
    void onEnter();

    void onExit();

    void update();

    void render(Renderer renderer);
}
