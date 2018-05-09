package game;

public class GameConfiguration
{
    private String name;
    private int width;
    private int height;
    private int renderScale;
    private double UPS;

    public GameConfiguration()
    {
        this.name = "Default Name";
        this.width = 500;
        this.height = 500;
        this.renderScale = 2;
        this.UPS = 60;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRenderScale() {
        return renderScale;
    }

    public void setRenderScale(int renderScale) {
        this.renderScale = renderScale;
    }

    public double getUPS() {
        return UPS;
    }

    public void setUPS(double UPS) {
        this.UPS = UPS;
    }
}
