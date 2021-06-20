// ID: 206628794
package Sprites;
import Behavior.*;
import Animation.*;
import GameLogic.*;
import biuoop.DrawSurface;
import java.awt.Color;


/**
 * @author Amit Shavit
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     *
     * @param center - ball center point
     * @param r      - ball radius
     * @param color  - ball color
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * Constructor.
     *
     * @param x     - x coordinate of ball center point
     * @param y     - y coordinate of ball center point
     * @param r     - ball radius
     * @param color - ball color
     */
    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * @return the x coordinate of this center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the  y coordinate of this center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the radius of this ball
     */
    public double getRadius() {
        return this.r;
    }

    /**
     * @return size of this ball
     */
    public int getSize() {
        double size = Math.PI * (this.r * this.r);
        return (int) size;
    }

    /**
     * @return the color of this ball
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return the velocity of this ball
     */
    public Velocity getVelocity() {
        return new Velocity(this.v.getDx(), this.v.getDy());
    }

    /**
     * @return the game environment of this ball
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * sets the game environment.
     * @param gameE - GameEnvironment
     */
    public void setGameEnvironment(GameEnvironment gameE) {
        this.gameEnvironment = gameE;
    }


    /**
     * sets the velocity using dx,dx params.
     *
     * @param dx - change in position on the 'x'
     * @param dy - change in position on the 'y'
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * sets the velocity using an existing velocity object.
     *
     * @param vel - velocity object
     */
    public void setVelocity(Velocity vel) {
        this.v = new Velocity(vel.getDx(), vel.getDy());
    }

    @Override
    public void drawOn(DrawSurface surface) {
        Color c = this.color;
        surface.setColor(c);
        surface.fillCircle(this.getX(), this.getY(), r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


    /**
     * changes ball center point to Make one move.
     */
    public void moveOneStep() {
        // special case for paddle - it may have moved and captured a ball - so move the ball out
        Rectangle paddleRect = getGameEnvironment().getPaddle().getCollisionRectangle();
        this.center = isInPaddle(paddleRect, this.center);

        Point newCenter = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(this.center, newCenter);
        CollisionInfo collision = gameEnvironment.getClosestCollision(trajectory);

        // found collision points
        if (collision != null) {
            Velocity newV = (collision.collisionObject().hit(this, collision.collisionPoint(), this.v));
            newCenter = newV.applyToPoint(this.center);
            trajectory = new Line(this.center, newCenter);
            collision = gameEnvironment.getClosestCollision(trajectory);
            // if still a collision - just send the ball back where it came from
            if (collision != null) {
                newV = new Velocity(-getVelocity().getDx(), -getVelocity().getDy());
                setVelocity(newV);
                newCenter =  this.getVelocity().applyToPoint(this.center);
            } else {
                this.setVelocity(newV);
            }
        }
        newCenter = isInPaddle(paddleRect, newCenter);
        this.center = newCenter;
    }

    /**
     * checks if the given point is in the given rectangle.
     *  @return new Point above the rectangle
     * @param paddleRect - rectangle of paddle
     * @param newCenter - center point of ball
     */
    private Point isInPaddle(Rectangle paddleRect, Point newCenter) {
        if (paddleRect.isInside(newCenter)) {
            //  Paddle fixup from inside the paddle to above
            newCenter = new Point(newCenter.getX(), paddleRect.getUpperLeft().getY() - 1);
        }
        return newCenter;
    }

    /**
     * remove this ball from game.
     * @param gameLevel - game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}
