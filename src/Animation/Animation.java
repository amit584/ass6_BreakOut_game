// ID: 206628794

package Animation;

import biuoop.DrawSurface;

public interface Animation {

    /**
     * @return boolean
     */
    boolean shouldStop();

    /**
     * the logic of the game. one fame actions.
     * @param d - surface of game
     */
    void doOneFrame(DrawSurface d);

}