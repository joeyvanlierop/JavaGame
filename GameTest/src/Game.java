import entities.EntityManager;
import entities.components.PositionComponent;
import entities.components.SpriteComponent;
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
            EntityManager.addComponent(player, new SpriteComponent(new Sprite(0, 16, 0, 16, new SpriteSheet("/img/player.png"))));
            EntityManager.addComponent(player, new PositionComponent(100, 250));
        }

        PositionComponent pos = (PositionComponent) EntityManager.getComponent(player, PositionComponent.class);

        TiledMap level_01 = TiledMapLoader.loadMap("/maps/Level01.json");
        //Player player = new Player(new SpriteSheet("/img/player.png"), 300, 250, 1.5, GameManager.getInputHandler(), level_01);
        Scene scene = new Scene(level_01);
        scene.

        GameManager.getCamera().init(player, level_01);
        GameManager.getInputHandler().registerKey(KeyEvent.VK_ESCAPE, () -> GameManager.stop());
        GameManager.getInputHandler().registerKey(KeyEvent.VK_ENTER, () -> GameManager.getEventManager().dispatchEvent(new CustomEvent()));

        GameManager.start(scene);

    }
}
