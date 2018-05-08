package states;

import gfx.Renderer;
import interfaces.IRenderable;
import interfaces.IUpdatable;

public abstract class State implements IUpdatable, IRenderable
{
    public abstract void tick();

    public abstract void render(Renderer renderer);
}
