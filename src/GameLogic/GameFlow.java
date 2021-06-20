//ID: 206628794
package GameLogic;
import Animation.*;
import Behavior.Counter;
import LevelInfo.LevelInformation;
import Sprites.SpriteCollection;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * @author Amit Shavit
 */
public class GameFlow {
    private GameEnvironment environment;
    private GUI gui;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter gameScore;

    /**
     * constructor.
     * @param gui - game gui
     * @param runner - game runner
     * @param keyboard - keyboard sensor
     */
    public GameFlow(GUI gui, AnimationRunner runner, KeyboardSensor keyboard) {
        this.gui = gui;
        this.runner = runner;
        this.keyboard = keyboard;
        this.gameScore = new Counter(0);
    }

    /**
     * a loop that iterates over all levels of game and runs them.
     * displays the win/lose/pause screen when needed.
     * @param levels - list of levels input.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            SpriteCollection sprites = new SpriteCollection();
            GameEnvironment gameEnvironment = new GameEnvironment();
            GameLevel level = new GameLevel(levelInfo, gameEnvironment, gui, sprites, runner, keyboard, gameScore);
            level.initialize();
            while (level.getBallC().getValue() != 0 && level.getBlockC().getValue() != 0) {
                level.run();
            }
            if (level.getBallC().getValue() == 0) {
                Animation screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                        new GameLost(keyboard, gameScore));
                level.getRunner().run(screen);
                if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                    gui.close();
                }
            }
        }
        Animation screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                new GameWon(keyboard, gameScore));
        this.runner.run(screen);
        gui.close();
    }
}