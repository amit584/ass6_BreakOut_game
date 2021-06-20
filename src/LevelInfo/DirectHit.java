//ID: 206628794
package LevelInfo;
import Behavior.*;
import Animation.*;
import Sprites.*;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Shavit
 */
public class DirectHit implements LevelInformation {
    static final int SPEED = 6;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        Point p = new Point(GameLevel.FRAME_WIDTH / 2.0, (GameLevel.FRAME_HEIGHT - (5 * GameLevel.BORDER_SIZE)));
        start.add(p);
        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel =  new ArrayList<>();
        vel.add(Velocity.fromAngleAndSpeed(0, SPEED));
        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background() {
            @Override
            public void drawOn(DrawSurface surface) {
                surface.setColor(new Color(154, 34, 34));
                /*surface.drawLine(GameLevel.FRAME_WIDTH / 2 , 2 * GameLevel.BORDER_SIZE,
                        GameLevel.FRAME_WIDTH / 2 , 2 * GameLevel.BORDER_SIZE + 200 );
                surface.drawLine(GameLevel.FRAME_WIDTH / 2 - 100, 12 * GameLevel.BORDER_SIZE,
                        GameLevel.FRAME_WIDTH / 2 + 100 , 12 * GameLevel.BORDER_SIZE);*/
                surface.fillCircle(GameLevel.FRAME_WIDTH / 2, 13 * GameLevel.BORDER_SIZE,
                        90);
                surface.setColor(Color.white);

                surface.fillCircle(GameLevel.FRAME_WIDTH / 2, 13 * GameLevel.BORDER_SIZE,
                        70);
                surface.setColor(new Color(154, 34, 34));
                surface.fillCircle(GameLevel.FRAME_WIDTH / 2, 13 * GameLevel.BORDER_SIZE,
                        50);
                surface.setColor(Color.BLACK);
                surface.fillRectangle(360, 360, 80, 120);
                surface.fillRectangle(340, 380, 120, 60);
                surface.fillRectangle(340, 340, 15, 30);
                surface.fillRectangle(445, 340, 15, 30);
                surface.fillRectangle(320, 355, 30, 15);
                surface.fillRectangle(445, 355, 30, 15);
                surface.fillRectangle(340, 460, 15, 30);
                surface.fillRectangle(445, 460, 15, 30);
                surface.fillRectangle(445, 445, 30, 15);
                surface.fillRectangle(325, 445, 30, 15);
                surface.setColor(Color.WHITE);
                surface.fillRectangle(375, 455, 15, 30);
                surface.fillRectangle(415, 455, 15, 30);
                surface.fillRectangle(365, 400, 30, 15);
                surface.fillRectangle(415, 400, 30, 15);








            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        Block b = new Block(new Rectangle(new Point(GameLevel.FRAME_WIDTH / 2 - Block.BLOCK_HEIGHT / 2, 115),
                Block.BLOCK_HEIGHT,
                Block.BLOCK_HEIGHT), Color.black);
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(b);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
