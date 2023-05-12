/*
 * 318192200
 * Dvir Amram
 * GameLevel
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * Initialization and running of a level in the game.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class GameLevel implements Animation {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int WIDTH_OF_BORDER = 20;
    static final int X_BALL = 400;
    static final int Y_BALL = 534;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     * @param levelInformation the level information
     * @param scr - the current score
     * @param ar the animation that should run
     */
    public GameLevel(LevelInformation levelInformation, Counter scr, AnimationRunner ar) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.score = scr;
        this.runner = ar;
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        this.levelInformation = levelInformation;
    }

    /**
     * adding collidable object to the list.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adding sprite object to the list.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * access to the collidable list.
     *
     * @return environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * adding object to the game lists.
     */
    public void initialize() {
        // Set boundaries at the edges of the surface
        Block b1 = new Block(new Rectangle(new Point(0, 0), WIDTH, WIDTH_OF_BORDER), Color.GRAY);
        Block b2 = new Block(new Rectangle(new Point(0, WIDTH_OF_BORDER), WIDTH_OF_BORDER,
                HEIGHT - WIDTH_OF_BORDER), Color.GRAY);
        Block b3 = new Block(new Rectangle(new Point(WIDTH_OF_BORDER, HEIGHT + WIDTH_OF_BORDER),
                WIDTH - WIDTH_OF_BORDER, WIDTH_OF_BORDER), Color.GRAY);
        Block b4 = new Block(new Rectangle(new Point(WIDTH - WIDTH_OF_BORDER, WIDTH_OF_BORDER), WIDTH_OF_BORDER,
                HEIGHT - WIDTH_OF_BORDER), Color.GRAY);
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);
        // create ball remover
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        b3.addHitListener(ballRemover);
        // create block remover
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        // create Score Tracking Listener
        ScoreTrackingListener scor = new ScoreTrackingListener(this.score);
        // Set blocks in rows (as in the picture in the example in the assigment)
        List<Block> blocks = this.levelInformation.blocks();
        for (Block b : blocks) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            this.blockCounter.increase(1);
            b.addHitListener(scor);
        }
        ScoreIndicator currentScore = new ScoreIndicator(scor);
        this.sprites.addSprite(currentScore);
        // set balls in the game
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(X_BALL, Y_BALL, 6, Color.white);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.ballCounter.increase(1);
        }
        //set the paddle and add it to the game
        Paddle paddle = new Paddle(this.runner.getGui().getKeyboardSensor(), this.levelInformation.paddleSpeed(),
                this.levelInformation.paddleWidth());
        paddle.addToGame(this);
        if (this.ballCounter.getValue() > 0 && this.blockCounter.getValue() > 0) {
            this.running = true;
        }
    }

    /**
     * running the level.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2,3,this.sprites));
        this.runner.run(this);
    }

    /**
     * A function receives a Collidable and removes it from the game's Collidable list.
     *
     * @param c - the Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getLst().remove(c);
    }

    /**
     * A function receives a sprite and removes it from the game's sprite list.
     *
     * @param s - the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getLst().remove(s);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        // draw blue background
        if (this.keyboard.isPressed("p")) {
            PauseScreen pauseScreen = new PauseScreen(this.keyboard);
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, pauseScreen));
        }
        this.levelInformation.getBackground().drawOn(d);
        // draw all the objects on the surface
        this.sprites.drawAllOn(d);
        // Change position according to the speed of each object
        // level name
        d.drawText(550, 20, "Level Name: " + this.levelInformation.levelName(), 18);
        this.sprites.notifyAllTimePassed();
        if (this.blockCounter.getValue() == 0 || this.ballCounter.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * access to the amount of the blocks that in the game.
     * @return NumberOfBlocks
     */
    public int getNumberOfBlocks() {
        return this.blockCounter.getValue();
    }

    /**
     * access to the amount of the balls that in the game.
     * @return NumberOfBalls
     */
    public int getNumberOfBalls() {
        return this.ballCounter.getValue();
    }
}
