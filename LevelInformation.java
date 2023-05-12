/*
 * 318192200
 * Dvir Amram
 * LevelInformation
 */
import java.util.List;
/**
 * An interface that each class that implements will be level in the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public interface LevelInformation {

    /**
     * the number of the players in the level.
     * @return num of balls
     */
    int numberOfBalls();

    /**
     * list of the ball's velocities.
     * @return list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle Speed.
     * @return paddleSpeed
     */
    int paddleSpeed();

    /**
     * return the paddle Width.
     * @return paddleWidth
     */
    int paddleWidth();

    /**
     * return the level name.
     * @return levelName
     */
    String levelName();

    /**
     * return the Back ground picture.
     * @return Background
     */
    Sprite getBackground();

    /**
     * return the list of the blocks that needs to be removed.
     * @return list of blocks
     */
    List<Block> blocks();

    /**
     * return the number of the blocks that needs to be removed.
     * @return number of the blocks that needs to be removed.
     */
    int numberOfBlocksToRemove();
}