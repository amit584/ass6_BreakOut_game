//ID: 206628794
package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import Behavior.*;

/**
 * @author Amit Shavit
 */
public class GameLost implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter gameScore;

    /**
     * constructor.
     * @param k - keyboard
     * @param gameScore - game score counter
     */
    public GameLost(KeyboardSensor k, Counter gameScore) {
        this.keyboard = k;
        this.stop = false;
        this.gameScore = gameScore;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + gameScore.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
