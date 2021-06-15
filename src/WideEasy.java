import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WideEasy implements LevelInformation{
    static final int SPEED = 6;
    static final int BLOCK_WIDTH = 780/15;
    static final int BLOCK_HEIGHT = 30;

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        for(int i = 0; i < numberOfBalls() / 2 ; i++) {
            Point p = new Point((380 - (i * BLOCK_HEIGHT)),
                    300 + (BLOCK_HEIGHT * i));
            start.add(p);
        }
        for(int i = 0; i < numberOfBalls() / 2 ; i++) {
            Point p =new Point((420 + (i * BLOCK_HEIGHT)),
                    300 + (BLOCK_HEIGHT * i));
            start.add(p);
        }
        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel =  new ArrayList<>();
        for(int i = 0; i < numberOfBalls() ; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(0 ,SPEED);
            vel.add(v);
        }
        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wilde Easy";
    }

    @Override
    public Sprite getBackground() {
        return null;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = new Color[]
                {Color.RED, Color.RED, Color.ORANGE,  Color.ORANGE, Color.YELLOW, Color.YELLOW, Color.GREEN,
                        Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE, Color.PINK, Color.PINK, Color.CYAN, Color.CYAN};
        for (int i = 0; i < 15; i++) {
                Point p = new Point(GameLevel.BORDER_SIZE + (i * BLOCK_WIDTH),
                        GameLevel.FRAME_HEIGHT / 2.0 - 2 * BLOCK_HEIGHT);
                Block block = new Block(BLOCK_HEIGHT, BLOCK_WIDTH, colors[i], p);
                blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }}
