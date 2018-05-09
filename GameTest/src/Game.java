import entities.Player;
import game.GameManager;
import gfx.SpriteSheet;
import level.Level;
import states.GameState;
import states.State;

public class Game {
    public static void main(String[] args)
    {
        GameManager.getConfiguration().setName("Test");
        GameManager.getConfiguration().setWidth(600);
        GameManager.getConfiguration().setHeight(600);
        GameManager.getConfiguration().setRenderScale(2);

        GameManager.init("/img/tile_sheet.png");

        Level level_01 = new Level("/levels/level_01.png");
        Player player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, GameManager.getInput(), level_01);
        State state_01 = new GameState(level_01, GameManager.getCamera(), player);

        GameManager.start(state_01);

        {
            System.out.println("TSET");
        }
    }
}
