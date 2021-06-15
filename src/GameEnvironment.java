//ID: 206628794
import java.util.ArrayList;

/**
 * @author Amit Shavit
 *  The GameEnvironment class is a collection of many objects a Ball can collide with. The ball will know the
 *  game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {

    private ArrayList<Collidable> collidables = new ArrayList<>();
    private Paddle paddle; // paddle needs special handling so we want to be able to get it

    /**
     * @return colidables list
     */
    public ArrayList<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * @return the paddle of the game environment.
     */
    public Paddle getPaddle() {
        return paddle;
    }

    /**
     * set the paddle of the game environment.
     * @param paddle - paddle object
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * adds the given collidable to the environment.
     * @param c - colldiable object
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * @return null - If this object will not collide with any of the collidables in this collection
     * otherwise, return the information about the closest collision that is going to occur.
     * @param trajectory - line
    **/
    public CollisionInfo getClosestCollision(Line trajectory) {
        double min = Double.MAX_VALUE;
        CollisionInfo collisionInfo = new CollisionInfo();
        boolean collides = false;
        for (Collidable collidable : collidables) {
            Point collision = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (collision != null) {
                double distance = trajectory.start().distance(collision);
                if (distance < min) {
                    collides = true;
                    min = distance;
                    collisionInfo.setCollidable(collidable);
                    collisionInfo.setCollisionPoint(collision);
                }
            }
        }
        if (!collides) {
            return null;
        }
        return collisionInfo;
    }

}