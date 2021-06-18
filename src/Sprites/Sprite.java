//ID: 206628794
package Sprites;
import biuoop.DrawSurface;
import Animation.*;


/**
 * @author Amit Shavit
 */

public interface Sprite {
    /**
     * draw the sprite on the screen.
     * @param surface - DrawSurface
     */
    void drawOn(DrawSurface surface);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * This method is in charge of adding the sprites to the game, calling the appropriate game methods.
     * @param g - game
     */
    void addToGame(GameLevel g);
}
