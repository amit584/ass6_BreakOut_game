//ID: 206628794

/**
 * @author Amit Shavit
 * a Block class implementing the Collidable interface
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit - block that is hit
     * @param hitter -  the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}