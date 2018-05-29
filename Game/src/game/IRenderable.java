package game;

import gfx.Renderer;

/*
 * Interface That Any Updateable Objects Implement
 */
public interface IRenderable
{
    /*
     * Render Method. Called Within RenderLoop.java
     *
     * TODO: Limit FPS In RenderLoop.java
     */
    void render(Renderer renderer);
}
