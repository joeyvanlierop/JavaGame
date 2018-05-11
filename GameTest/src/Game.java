import entities.Player;
import game.GameManager;
import gfx.SpriteSheet;
import level.Level;
import states.GameState;
import states.State;

public class Game extends GameManager
{
    public static void main(String[] args)
    {
        getConfiguration().setName("Test");
        getConfiguration().setWidth(600);
        getConfiguration().setHeight(600);
        getConfiguration().setRenderScale(1);
        getConfiguration().setUPS(60);

        init("/img/tile_sheet.png");

        Level level_01 = new Level("/levels/level_01.png");
        Player player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, GameManager.getInput(), level_01);
        State state_01 = new GameState(level_01, GameManager.getCamera(), player);

        start(state_01);
    }
}
