//ID:  206628794
/**
 * @author Amit Shavit
 * holds the information about the collision that is going to occur (object, point)
 */
public class CollisionInfo {
    private Point  collisionPoint;
    private Collidable  collidable;

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
      */
    public Collidable collisionObject() {
        return this.collidable;
    }

    /**
     * set the point at which the collision occurs.
     * @param collisionPoint - collision Point
     */
    public void setCollisionPoint(Point collisionPoint) {
        this.collisionPoint = collisionPoint;
    }

    /**
     * set the collidable object involved in the collision.
     * @param collidable   -  collidable object
     */
    public void setCollidable(Collidable collidable) {
        this.collidable = collidable;
    }
}