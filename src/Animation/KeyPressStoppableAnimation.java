//ID: 206628794
package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Amit Shavit
 */
public class KeyPressStoppableAnimation extends AbstractAnimationDecorator {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed = true;

    /**
     * constructor.
     * @param sensor - keyboard sensor
     * @param key - string
     * @param animation - animation we want to run and control with the key press
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        super(animation);
        this.sensor = sensor;
        this.key = key;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        super.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (isAlreadyPressed) {
            } else {
                this.stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
    }
}
