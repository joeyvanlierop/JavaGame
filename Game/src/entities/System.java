package entities;

import game.IRenderable;
import game.IUpdatable;
import gfx.Renderer;

public abstract class System implements IUpdatable, IRenderable
{
    //https://cbpowell.wordpress.com/2012/12/07/entity-component-game-programming-using-jruby-and-libgdx-part-4/

    public void update() { }

    public void render(Renderer renderer) { }
}
