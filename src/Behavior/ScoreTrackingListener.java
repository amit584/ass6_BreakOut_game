//ID: 206628794
package Behavior;
import Sprites.*;

/**
 * @author Amit Shavit
 * a Block class implementing the Collidable interface
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter - counter of game score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * blacks that are hit increase the game score by 5 points.
     * @param beingHit - block that is hit
     * @param hitter -  the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       currentScore.increase(5);
    }
}