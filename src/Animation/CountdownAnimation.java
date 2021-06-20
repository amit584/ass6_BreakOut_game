// ID: 206628794
package Animation;
import Sprites.SpriteCollection;
import biuoop.DrawSurface;

/** The CountdownAnimation will display the given gameScreen, for numOfSeconds seconds, and on top of them it will show
 * a countdown from 3 back to 1, before it is replaced with the next one.
 **/
public class CountdownAnimation implements Animation {
    private int numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop = false;

    /**
     * constructor.
     * @param numOfSeconds - number of seconds to pause screen
     * @param countFrom - int to count from
     * @param gameScreen - sprites that we want to display on screen.
     */
    public CountdownAnimation(int numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        long startTime = System.currentTimeMillis(); // timing
        gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 2 - 32, d.getHeight() / 2, "Start: " + this.countFrom, 32);
        long usedTime = System.currentTimeMillis() - startTime;
        sleeper.sleepFor(1000 / numOfSeconds);
        this.countFrom--;
        if (this.countFrom < 0) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}