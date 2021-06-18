// ID: 206628794
package Behavior;
import Animation.*;
import Sprites.*;
/**
 * @author Amit Shavit
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     * @param gameLevel - game level
     * @param removedBalls - counter of balls removed
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * balls that are hitting a specific block are removed from the game.
     * @param beingHit - block that is hit
     * @param hitter -  the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
    }
}