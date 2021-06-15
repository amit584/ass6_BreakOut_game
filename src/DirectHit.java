import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DirectHit implements LevelInformation{
    static final int SPEED = 6;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        Point p = new Point(GameLevel.FRAME_WIDTH / 2.0 ,
                ( GameLevel.FRAME_HEIGHT - (5 * GameLevel.BORDER_SIZE)));
        start.add(p);
        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel =  new ArrayList<>();
        vel.add(Velocity.fromAngleAndSpeed(0,SPEED));
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
        return null;
    }

    @Override
    public List<Block> blocks() {
        Block b = new Block(new Rectangle(new Point(GameLevel.FRAME_WIDTH / 2 - Block.BLOCK_HEIGHT / 2, 4 * GameLevel.BORDER_SIZE), Block.BLOCK_HEIGHT,
                Block.BLOCK_HEIGHT), Color.RED);
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(b);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
