import entities.EntityManager;
import entities.components.*;
import entities.systems.CameraFollowSystem;
import entities.systems.MovementSystem;
import entities.systems.SpriteRendererSystem;
import events.CustomEvent;
import game.GameManager;
import gfx.Sprite;
import gfx.SpriteSheet;
import level.TiledMap;
import level.TiledMapLoader;
import scenes.Scene;

import java.awt.event.KeyEvent;
import java.util.UUID;

public class Game extends GameManager
{
    public static void main(String[] args)
    {
        GameManager.getConfiguration().setName("Test");
        GameManager.getConfiguration().setWidth(600);
        GameManager.getConfiguration().setHeight(600);
        GameManager.getConfiguration().setRenderScale(2);
        GameManager.getConfiguration().setUPS(60);
        GameManager.init();

        UUID player = EntityManager.createEntity();

        {
            EntityManager.addSingletonComponent(player, new SpriteComponent(new Sprite(0, 16, 16, 16, new SpriteSheet("/img/player.png"))));
            EntityManager.addSingletonComponent(player, new PositionComponent(50, 50));
            EntityManager.addSingletonComponent(player, new MovementComponent(1));
            EntityManager.addSingletonComponent(player, new CameraTargetComponent());
        }

        MovementComponent move = (MovementComponent) EntityManager.getComponent(player, MovementComponent.class);

        TiledMap level_01 = TiledMapLoader.loadMap("/maps/Level01.json");
        Scene scene = new Scene(level_01);
        scene.addSystem(new SpriteRendererSystem());
        scene.addSystem(new MovementSystem());
        scene.addSystem(new CameraFollowSystem());

        CameraComponent cam = (CameraComponent) EntityManager.getComponent(getCamera(), CameraComponent.class);
        cam.setBounds(level_01);

        GameManager.getInputHandler().registerKey(KeyEvent.VK_ESCAPE, () -> GameManager.stop());
        GameManager.getInputHandler().registerKey(KeyEvent.VK_ENTER, () -> GameManager.getEventManager().dispatchEvent(new CustomEvent()));
        GameManager.getInputHandler().registerKey(KeyEvent.VK_D, () -> move.setXMove(1));
        GameManager.getInputHandler().registerKey(KeyEvent.VK_P, () -> EntityManager.destroyEntity(player));
        GameManager.getInputHandler().registerKey(KeyEvent.VK_Z, () -> cam.clearBounds());

        GameManager.start(scene);

    }
}
