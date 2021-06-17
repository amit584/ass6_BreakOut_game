import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation extends AbstractAnimationDecorator {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;



    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        super(animation);
    }

    @Override
    public boolean shouldStop() {
        return super.shouldStop();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        super.doOneFrame(d);
        if (this.sensor.isPressed(key)) {this.stop = true;}
    }
}
