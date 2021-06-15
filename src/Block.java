//ID: 206628794

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Shavit
 * a Block class implementing the Collidable interface
 */
class Block implements Collidable, Sprite, HitNotifier {
    static final int BLOCK_WIDTH = 50;
    static final int BLOCK_HEIGHT = 30;
    //fields
    private Rectangle shape;
    private Color color;
    private List<HitListener> hitListeners = new ArrayList<HitListener>();


    /**
     * Constructor.
     * @param shape - rectangle object
     * @param color     - block color
     */
    public Block(Rectangle shape, Color color) {
        this.shape = shape;
        this.color = color;
    }
    /**
     * Constructor.
     * @param p - upper left point
     * @param color  - block color
     */
    public Block(Color color, Point p) {
        this.shape = new Rectangle(p, BLOCK_WIDTH, BLOCK_HEIGHT);
        this.color = color;
    }

    /**
     * Constructor.
     * @param height - block height
     * @param width - block width
     * @param p - upper left point
     * @param color  - block color
     */
    public Block(int height, int width, Color color, Point p) {
        this.shape = new Rectangle(p, width, height);
        this.color = color;
    }

    @Override
    public void  drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
    }

    @Override
    public void timePassed() { }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] edges = shape.getEdges();
        if (edges[Rectangle.TOP].isOn(collisionPoint) || edges[Rectangle.BOTTOM].isOn(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (edges[Rectangle.LEFT].isOn(collisionPoint) || edges[Rectangle.RIGHT].isOn(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return null;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove this block from game.
     * @param gameLevel - game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * will be called whenever a hit() occurs, and will notify all of the registered HitListener
     * objects by calling their hitEvent method.
     * @param hitter -   the Ball that's doing the hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}