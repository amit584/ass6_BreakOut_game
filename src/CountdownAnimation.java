import biuoop.DrawSurface;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private int numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop = false;

    public CountdownAnimation(int numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        long startTime = System.currentTimeMillis(); // timing
        gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 2 - 32, d.getHeight() / 2, "Start: " + this.countFrom, 32);
        long usedTime = System.currentTimeMillis() - startTime;
        sleeper.sleepFor(1000/this.numOfSeconds);
        this.countFrom--;
        if (this.countFrom < 0) {
            this.stop = true;
        }
    }
    public boolean shouldStop() {
        return this.stop;
    }
}