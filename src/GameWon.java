import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class GameWon implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter gameScore;


    public GameWon(KeyboardSensor k, Counter gameScore) {
        this.keyboard = k;
        this.stop = false;
        this.gameScore = gameScore;
    }

    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + gameScore.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    public boolean shouldStop() { return this.stop; }
}