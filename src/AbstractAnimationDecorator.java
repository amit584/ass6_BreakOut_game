import biuoop.DrawSurface;

public abstract class AbstractAnimationDecorator implements Animation {
    private Animation decorated;

    public AbstractAnimationDecorator(Animation animation){
        this.decorated = animation;
    }

    @Override
    public boolean shouldStop() {
        return decorated.shouldStop();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        decorated.doOneFrame(d);
    }
}
