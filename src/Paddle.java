//ID: 206628794
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Amit Shavit
 * The Paddle is the player in the game. It is a rectangle that is controlled by the arrow keys, and moves
 * according to the player key presses. It implement the Sprite and the Collidable interfaces.
 */
public class Paddle implements Sprite, Collidable {
    static final int SPEED = 6;
    static final int VERTICAL = 180;
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle shape;
    private int speed;

    /**
     * Constructor.
     *
     * @param shape - rectangle object
     * @param gui  - game gui
     */
    public Paddle(Rectangle shape, GUI gui, int speed) {

        this.keyboard = gui.getKeyboardSensor();
        this.shape =  shape;
        this.speed = speed;
    }

    /**
     * sets a new UpperLeft point of paddle.
     * decreases the X coordinates to make a move to the left without going over game borders
     */
    public void moveLeft() {
        Point newUpperLeft = new Point(this.shape.getUpperLeft().getX() - speed, this.shape.getUpperLeft().getY());
        if (newUpperLeft.getX() < 0) {
            //including border width
            newUpperLeft.setX(10);
        }
        this.shape.setUpperLeft(newUpperLeft);
    }

    /**
     * sets a new UpperLeft point of paddle.
     * increases the X coordinates to make a move to the right without going over game borders
     * */
    public void moveRight() {
        Point newUpperLeft = new Point(this.shape.getUpperLeft().getX() + speed, this.shape.getUpperLeft().getY());
        if (newUpperLeft.getX() + shape.getWidth() > 800) {
            //including border width
            newUpperLeft.setX(790 - shape.getWidth());
        }
        this.shape.setUpperLeft(newUpperLeft);
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    @Override
    public Velocity hit(Ball hitter,Point collisionPoint, Velocity currentVelocity) {
        Line[] edges = shape.getEdges();
        if (edges[Rectangle.TOP].isOn(collisionPoint)) {
            double distanceHit = collisionPoint.distance(shape.getUpperLeft());
            int region = (int) distanceHit / (int) (shape.getWidth() / 5);
            return switch (region) {
                case 0 -> Velocity.fromAngleAndSpeed(VERTICAL + 60, SPEED);
                case 1 -> Velocity.fromAngleAndSpeed(VERTICAL + 30, SPEED);
                case 2 -> Velocity.fromAngleAndSpeed(VERTICAL, SPEED);
                case 3 -> Velocity.fromAngleAndSpeed(VERTICAL - 30, SPEED);
                case 4 -> Velocity.fromAngleAndSpeed(VERTICAL - 60, SPEED);
                default -> currentVelocity;
            };
        }
        if (edges[Rectangle.LEFT].isOn(collisionPoint) || edges[Rectangle.RIGHT].isOn(collisionPoint)) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return null;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}