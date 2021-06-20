// ID: 206628794
import LevelInfo.*;
import GameLogic.*;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import Animation.*;
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
        for (String arg : args) {
            System.out.println(arg);
        }
        if (args.length == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        } else {
            for (String arg : args) {
                if (arg.equals("1")) {
                    levels.add(new DirectHit());
                }
                if (arg.equals("2")) {
                    levels.add(new WideEasy());
                }
                if (arg.equals("3")) {
                    levels.add(new Green3());
                }
                if (arg.equals("4")) {
                    levels.add(new FinalFour());
                }
            }
        }
        GameFlow game = new GameFlow(gui, runner, keyboard);
        game.runLevels(levels);
    }
}