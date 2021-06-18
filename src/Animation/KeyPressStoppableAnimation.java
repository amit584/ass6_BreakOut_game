package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation extends AbstractAnimationDecorator {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed = true;



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
                isAlreadyPressed=false;
                this.stop = true;
        }
    }
}
