//ID:206628794
/**
 * @author Amit Shavit
 * The Collidable interface will be used by things that can be collided with/
 * everything that we can collide into is rectangular.
 */
public interface Collidable {

    /**
     * @return  the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     *  Notify the object that we collided with it at collisionPoint with a given velocity.
     *  @return is the new velocity expected after the hit
     *  @param collisionPoint - the collision  point
     *  @param currentVelocity  -  balls  current  velocity
     * @param hitter - ball of hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
