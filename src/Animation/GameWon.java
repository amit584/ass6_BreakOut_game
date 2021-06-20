//ID: 206628794
package Animation;
import Behavior.*;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Amit Shavit
 */
public class GameWon implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter gameScore;

    /**
     * constructor.
     * @param k - keyboard
     * @param gameScore - game score counter
     */
    public GameWon(KeyboardSensor k, Counter gameScore) {
        this.keyboard = k;
        this.stop = false;
        this.gameScore = gameScore;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + gameScore.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}