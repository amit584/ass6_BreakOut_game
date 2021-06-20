//ID: 206628794
package LevelInfo;
import Sprites.*;
import Behavior.*;
import java.util.List;

/**
 * @author Amit Shavit
 */
public interface LevelInformation {
    /**
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * @return balls starting points.
     */
    List<Point> ballsStartPoints();

    /**
     * @return a list with the initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return paddle speed.
     */
    int paddleSpeed();
    /**
     * @return paddle width.
     */
    int paddleWidth();
    /**
     * @return the level name.
     */
    String levelName();
    /**
     * @return sprite that represent the background.
     */
    Sprite getBackground();
    /**
     * @return list of blocks
     */
    List<Block> blocks();

    /**
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     **/
    int numberOfBlocksToRemove();
}