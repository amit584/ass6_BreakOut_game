package GameLogic;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import Animation.*;
import Sprites.*;
import Behavior.*;
import LevelInfo.*;
import java.util.List;

public class GameFlow {
    private GameEnvironment environment;
    private GUI gui;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter gameScore;

    public GameFlow(GUI gui, AnimationRunner runner, KeyboardSensor keyboard) {
        this.gui = gui;
        this.runner = runner;
        this.keyboard = keyboard;
        this.gameScore = new Counter(0);
    }

    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            SpriteCollection sprites = new SpriteCollection();
            GameEnvironment environment = new GameEnvironment();
            GameLevel level = new GameLevel(levelInfo, environment, gui, sprites, runner, keyboard, gameScore);
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