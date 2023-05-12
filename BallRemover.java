/*
 * 318192200
 * Dvir Amram
 * ScoreIndicator
 */

/**
 * An object that is responsible for removing the balls from the game.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game         - the game
     * @param removedBalls - the ball
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.game.removeSprite(hitter);
        this.remainingBalls.decrease(1);
    }
}
