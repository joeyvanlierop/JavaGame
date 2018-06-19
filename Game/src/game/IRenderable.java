package game;

import gfx.Renderer;

/**
 * Interface That Updateable Objects Implement
 * May Be Removed In The Future
 */
public interface IRenderable
{
    /**
     * Render Method. Called Within RenderLoop.java
     * TODO: Limit FPS In RenderLoop.java
     *
     * @param renderer The {@link Renderer} Class
     */
    void render(Renderer renderer);
}
