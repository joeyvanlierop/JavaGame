package game;

import entities.interfaces.IUpdatable;

import java.util.ArrayList;

public class UpdateHandler implements Runnable {
    private ArrayList<IUpdatable> updatables;
    private boolean running = false;
    private Thread thread;

    private double UPS;
    private Game game;

    public UpdateHandler(double UPS, Game game)
    {
        this.updatables = new ArrayList<>();
        this.UPS = UPS;
        this.game = game;
    }

    public void addUpdatable(IUpdatable updatable)
    {
        updatables.add(updatable);
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

            while (deltaTime >= 1.0) {
                tick();
                updates++;
                deltaTime -= 1.0;
            }

            game.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                System.out.println(String.format("FPS: %d, UPS: %d\n", frames, updates));

                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick()
    {
        for (IUpdatable updatable : updatables) {
            updatable.tick();
        }
    }
}
