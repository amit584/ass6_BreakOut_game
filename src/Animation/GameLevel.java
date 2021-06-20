// ID: 206628794
package Animation;
import Behavior.*;
import GameLogic.GameEnvironment;
import LevelInfo.LevelInformation;
import Sprites.*;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Amit Shavit
 *  The Game class holds the sprites and the collidables, and is in charge of the animation
 */
public class GameLevel implements Animation {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int BORDER_SIZE = 10;
    public static final int PADDLE_HEIGHT = 20;
    public static final int RADIUS = 5;
    public static final int SPEED = 6;
    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter ballC;
    private Counter blockC;
    private AnimationRunner runner;
    private Counter gameScore;
    private boolean running;
    private LevelInformation info;
    private KeyboardSensor keyboard;


    /**
     *  constructor.
     * @param info - level information
     * @param environment - level environment
     * @param gui - gui of game
     * @param sprites - sprites of level
     * @param runner - game runner
     * @param keyboard - keyboard sensor
     * @param gameScore - game score counter
     */
    public GameLevel(LevelInformation info, GameEnvironment environment, GUI gui, SpriteCollection sprites,
                     AnimationRunner runner, KeyboardSensor keyboard, Counter gameScore) {
        this.gui = gui;
        this.sprites = sprites;
        this.environment = environment;
        this.runner = runner;
        this.keyboard = keyboard;
        this.info = info;
        this.gameScore = gameScore;
        this.ballC = new Counter(info.numberOfBalls());
        this.blockC = new Counter(info.numberOfBlocksToRemove());
        this.running = true;
    }

    /**
     * get ball counter of level.
     * @return counter
     */
    public Counter getBallC() {
        return ballC;
    }
    /**
     * get block counter of level.
     * @return counter
     */
    public Counter getBlockC() {
        return blockC;
    }

    /**
     * get runner of level.
     * @return animationRunner
     */
    public AnimationRunner getRunner() {
        return runner;
    }

    /**
     * adds given object to the environment collidables.
     * @param c - collidable object
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * adds given object to the sprites collection.
     * @param s - sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * creates new block objects that define te borders of the screen.
     * size, color, location are fixed.
     */
    private void createBorders() {
        Block scoreIndicator = new Block(new Rectangle(new Point(0, 0), FRAME_WIDTH, 2 * BORDER_SIZE), Color.white);
        scoreIndicator.addToGame(this);
        Block lowerBorder = new Block(new Rectangle(new Point(0, FRAME_HEIGHT - BORDER_SIZE), FRAME_WIDTH, BORDER_SIZE),
                Color.BLACK);
        lowerBorder.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, this.ballC);
        lowerBorder.addHitListener(ballRemover);
        // upper border
        (new Block(new Rectangle(new Point(0, 2 * BORDER_SIZE), FRAME_WIDTH, BORDER_SIZE),
                Color.BLACK)).addToGame(this);
        // left border
        (new Block(new Rectangle(new Point(0, 0), BORDER_SIZE, FRAME_HEIGHT),
                Color.BLACK)).addToGame(this);
        // right border
        (new Block(new Rectangle(new Point(FRAME_WIDTH - BORDER_SIZE, 0),
                BORDER_SIZE, FRAME_HEIGHT), Color.BLACK)).addToGame(this);
    }

    /**
     * creates new blocks on the screen according to level information.
     * adds listeners and counters to blocks
     * @param remover block remover count
     * @param score - score tracking listener
     */
    private void creatBlocks(BlockRemover remover, ScoreTrackingListener score) {
        for (int i = 0; i < info.blocks().size(); i++) {
            Block block = info.blocks().get(i);
            block.addHitListener(remover);
            block.addHitListener(score);
            block.addToGame(this);
        }
    }
    /**
     * creates new balls on the screen according to level information.
     */
    private void creatBalls() {
        for (int i = 0; i < info.numberOfBalls(); i++) {
            Ball ball1 = new Ball(info.ballsStartPoints().get(i), RADIUS, Color.RED);
            ball1.setVelocity(info.initialBallVelocities().get(i));
            ball1.setGameEnvironment(this.environment);
            ball1.addToGame(this);
        }
    }
    /**
     * creates new paddle on the screen according to level information.
     */
    private void creatPaddle() {
        Paddle p  = new Paddle(new Rectangle(new Point(FRAME_WIDTH / 2.0 - info.paddleWidth() / 2.0,
                FRAME_HEIGHT - BORDER_SIZE - PADDLE_HEIGHT), info.paddleWidth(), PADDLE_HEIGHT), gui,
                info.paddleSpeed());
        p.addToGame(this);
        this.environment.setPaddle(p);
    }

    /**
     * Initialize a new game: creates the Blocks, Balls, Paddle, and Score board and adds them to the game.
     */
    public void initialize() {
        //creat balls
        creatBalls();

        //creat borders
        this.createBorders();

        //creat listeners
        BlockRemover remove = new BlockRemover(this, blockC);
        ScoreTrackingListener score = new ScoreTrackingListener(gameScore);

        //creat blocks
        this.creatBlocks(remove, score);

        //create paddle
        creatPaddle();

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.info.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        d.drawText(FRAME_WIDTH / 2 - BORDER_SIZE, 15, "Score: " + gameScore.getValue(), 15);
        d.drawText(FRAME_WIDTH / 2 + 120, 15, "Level Name: " + info.levelName(), 15);
        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            Animation screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(keyboard));
            this.runner.run(screen);
        }
        if (ballC.getValue() == 0 || blockC.getValue() == 0) {
            this.running = false;
        }
    }
    /**
     * * run the current animation.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.runner.run(this);
    }

    /**
     * @param c - removed from the GameEnvironment
     */
    public void removeCollidable(Collidable c) {
        environment.getCollidables().remove(c);
    }

    /**
     * @param s - removed from the SpriteCollection
     */
    public void removeSprite(Sprite s) {
        sprites.getSprites().remove(s);
    }

    @Override
    public boolean shouldStop() {
       return !this.running;
    }
}