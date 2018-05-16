package game;

import gfx.Renderer;
import interfaces.IRenderable;

import java.util.ArrayList;

public class RenderLoop {
    private ArrayList<IRenderable> renderables;
    private Renderer renderer;

    public RenderLoop(Renderer renderer)
    {
        this.renderables = new ArrayList<>();
        this.renderer = renderer;
    }

    public void addRenderable(IRenderable renderable)
    {
        renderables.add(renderable);
    }

    public void render()
    {
        for (IRenderable renderable : renderables) {
            renderable.render(renderer);
        }

        renderer.render();
    }
}
