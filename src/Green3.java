import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Green3 implements LevelInformation{
    static final int SPEED = 6;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Point p = new Point((390 + (2 * i * Block.BLOCK_HEIGHT)),
                    400 + (Block.BLOCK_HEIGHT));
            start.add(p);
        }
        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel =  new ArrayList<>();
        vel.add(Velocity.fromAngleAndSpeed(0,SPEED));
        vel.add(Velocity.fromAngleAndSpeed(0,SPEED));

        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 110;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return null;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        Color[] colors = new Color[]
                {new Color(153, 204, 255), new Color(102, 178, 255), new Color(51, 153, 255),
                        new Color(0, 128, 255), new Color(0, 102, 204), new Color(0, 76, 158)};
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < 10 - i; j++) {
                Point  p = new Point(GameLevel.FRAME_WIDTH - GameLevel.BORDER_SIZE - 1 - ((j + 1) * Block.BLOCK_WIDTH), 100
                        + (Block.BLOCK_HEIGHT * i));
                Block block = new Block(colors[i - 1], p);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 35;
    }
}
