//ID: 206628794
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Shavit
 * holds a collection of sprites, supports the addition of new sprites
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    /**
     * adds new sprite.
     * @param s - new sprite to add
     */
    public void addSprite(Sprite s)  {
        sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<Sprite>(sprites);
        for (Sprite sprite : spriteList) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d - surface
     **/
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}