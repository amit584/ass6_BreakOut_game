import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class GameLost implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter gameScore;

    public GameLost(KeyboardSensor k, Counter gameScore) {
        this.keyboard = k;
        this.stop = false;
        this.gameScore = gameScore;
    }

    protected void setStop(boolean stop) {
        this.stop = stop;
    }

    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + gameScore.getValue(), 32);
    }
    public boolean shouldStop() {return this.stop;}
}
