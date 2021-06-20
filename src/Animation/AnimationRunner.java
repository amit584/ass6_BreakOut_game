// ID: 206628794
package Animation;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The AnimationRunner takes an Animation object and runs it.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * constructor.
     * @param gui - game gui
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
    }

    /**
     * creates the time loop of the game and runs the wanted animation.
     * @param animation - the animation we want to run
     */
    public void run(Animation animation) {
        this.framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}