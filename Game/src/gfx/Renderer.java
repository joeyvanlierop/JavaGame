package gfx;

import game.Camera;
import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Renderer {
    private int[] pixels;

    private Camera camera;

    private BufferedImage view;

    public Renderer(Camera player)
    {
        this.camera = player;

        this.view = new BufferedImage(camera.getViewportWidth(), camera.getViewportHeight(), BufferedImage.TYPE_INT_RGB);
        this.pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
    }

    public void clearScreen(int color)
    {
        for (int pixelIndex = 0; pixelIndex < pixels.length; pixelIndex++) {
            pixels[pixelIndex] = color;
        }
    }

    //TODO: Improve Scaling
    public void render(Graphics g)
    {
        int scale;

        if (Game.width > Game.height) {
            scale = Game.width - camera.getViewportWidth();
        } else {
            scale = Game.height - camera.getViewportWidth();
        }

        g.drawImage(view, 0, 0, camera.getViewportWidth() + scale, camera.getViewportHeight() + scale, null);
        g.dispose();
    }

    public void renderPixel(int x, int y, int color)
    {
        if (x >= 0 && x < camera.getViewportHeight()) {
            double pixelIndex = x + y * camera.getViewportWidth();

            if (color != 0xffff00ff) {
                if (pixelIndex < pixels.length && pixelIndex >= 0) {
                    pixels[(int) pixelIndex] = color;
                }
            }
        }
    }

    public void renderSprite(int spritePixels[], int xPosition, int yPosition, int spriteWidth, int spriteHeight)
    {
        for (int y = 0; y < spriteHeight; y++) {
            for (int x = 0; x < spriteWidth; x++) {

                renderPixel(x + xPosition - camera.getX(),
                            y + yPosition - camera.getY(),
                            spritePixels[x + y * spriteWidth]);
            }
        }
    }
}
