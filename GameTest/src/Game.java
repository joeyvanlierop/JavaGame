import entities.Player;
import game.Camera;
import game.GameManager;
import gfx.SpriteSheet;
import level.Level;
import states.GameState;
import states.State;

public class Game {
    public static void main(String[] args)
    {
        Camera camera = new Camera(300, 300);

        GameManager.init(600, 600, camera, "/img/tile_sheet.png");

        Level level_01 = new Level("/levels/level_01.png");
        Player player = new Player(new SpriteSheet("/img/player.png"), 250, 250, 1.5, GameManager.getInput(), level_01);
        State state_01 = new GameState(level_01, GameManager.getCamera(), player);

        GameManager.start(state_01);
    }
}
