//ID: 206628794
package LevelInfo;
import java.awt.Color;
import Animation.*;
import Sprites.*;
import Behavior.Velocity;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Shavit
 */
public class FinalFour implements LevelInformation {
    static final int SPEED = 6;
    static final int BLOCK_WIDTH = 780 / 15;
    static final int BLOCK_HEIGHT = 30;

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        Point p1 = new Point(340, 400 + (BLOCK_HEIGHT));
        Point p2 = new Point(400, 370 + (BLOCK_HEIGHT));
        Point p3 = new Point(460, 400 + (BLOCK_HEIGHT));
        start.add(p1);
        start.add(p2);
        start.add(p3);

        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel =  new ArrayList<Velocity>();
        vel.add(Velocity.fromAngleAndSpeed(0, SPEED));
        vel.add(Velocity.fromAngleAndSpeed(0, SPEED));
        vel.add(Velocity.fromAngleAndSpeed(0, SPEED));
        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background() {
            @Override
            public void drawOn(DrawSurface surface) {
                surface.setColor(new Color(32, 44, 68));
                surface.fillRectangle(0, 0, GameLevel.FRAME_WIDTH + GameLevel.BORDER_SIZE,
                        GameLevel.FRAME_HEIGHT + GameLevel.BORDER_SIZE);
                surface.setColor(new Color(177, 133, 86));
                surface.fillCircle(400, 300, 120);
                surface.setColor(new Color(31, 88, 113));
                surface.fillRectangle(0, 350, GameLevel.FRAME_WIDTH, GameLevel.FRAME_HEIGHT - 350);
                surface.setColor(new Color(32, 44, 68));
                surface.drawText(100, 500, "GOOD NIGHT", 30);

            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = new Color[]{Color.RED, Color.RED, Color.ORANGE, Color.YELLOW,
                Color.BLUE, Color.PINK, Color.CYAN};
        for (int j = 6; j > 0; j--) {
            for (int i = 0; i < 15; i++) {
                Point p = new Point(GameLevel.BORDER_SIZE + (i * BLOCK_WIDTH),
                        50 + j * BLOCK_HEIGHT);
                Block block = new Block(BLOCK_HEIGHT, BLOCK_WIDTH, colors[j], p);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 90;
    }
}
