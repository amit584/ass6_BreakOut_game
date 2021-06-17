// ID: 206628794

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Shavit
 * Ass3Game  - putting it all together
 */
public class Ass6Game {
    /**
     * main method that does the following:
     * Creates a game object, initializes and runs it. the screen  is 800 * 600.
     * The game includes a paddle (which is controlled by the left and right arrows), two balls, and blocks.
     * @param args (empty)
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui);
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        //levels.add(new DirectHit());
        levels.add(new WideEasy());
        //levels.add(new Green3());
        //levels.add(new FinalFour());
        GameFlow game = new GameFlow(gui, runner, keyboard);
        game.runLevels(levels);
    }
}