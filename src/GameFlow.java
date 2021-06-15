import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {

    private GameEnvironment environment;
    private GUI gui;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter gameScore;

    public GameFlow(GameEnvironment environment, GUI gui, AnimationRunner runner,
                    KeyboardSensor keyboard, Counter gameScore) {
        this.environment = environment;
        this.gui = gui;
        this.runner = runner;
        this.keyboard = keyboard;
        this.gameScore = gameScore;
    }

    public void runLevels(List<LevelInformation> levels) {
        SpriteCollection sprites = new SpriteCollection();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, environment, gui, sprites, runner, keyboard, gameScore);
            level.initialize();
            level.run();
            /*if (level.getBallC().getValue() == 0) {
                level.getRunner().run(new GameLost(keyboard, gameScore));
                if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                    gui.close();
                }
            }*/
        }
        this.runner.run(new GameWon(this.keyboard, gameScore));
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            gui.close();
        }
    }
}