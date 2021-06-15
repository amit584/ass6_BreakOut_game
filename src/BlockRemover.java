//ID: 206628794
/**
 * @author Amit Shavit
 * a Block class implementing the Collidable interface
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor.
     * @param gameLevel - game
     * @param removedBlocks - counter of blocks removed
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * blacks that are hit are removed from the game.
     * remaining block counter is decreasing.
     * @param beingHit - block that is hit
     * @param hitter -  the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}