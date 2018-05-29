package game;

public class GameLoop implements Runnable {

    private double UPS;
    private boolean running = false;
    private Thread thread;

    private UpdateLoop updateLoop;
    private RenderLoop renderLoop;

    public GameLoop(double UPS, UpdateLoop updateLoop, RenderLoop renderLoop)
    {
        this.UPS = UPS;
        this.updateLoop = updateLoop;
        this.renderLoop = renderLoop;
    }

    public synchronized void start()
    {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        final double UPS_NS = 1000000000 / UPS;

        double deltaTime = 0;
        long currentTime = System.nanoTime();
        long lastTime = currentTime;
        long timer = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (running) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / UPS_NS;
            lastTime = currentTime;

            while (deltaTime >= 1.0)
            {
                updateLoop.update();
                updates++;
                deltaTime -= 1.0;
            }

            renderLoop.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                GameManager.getWindow().setTitle(String.format("FPS: %d, UPS: %s", frames, updates));

                frames = 0;
                updates = 0;
            }
        }
    }
}
