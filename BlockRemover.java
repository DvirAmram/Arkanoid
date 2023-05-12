/*
 * 318192200
 * Dvir Amram
 * BlockRemover
 */

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          - the game
     * @param removedBlocks - the block
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        this.game.removeCollidable(beingHit);
        this.game.removeSprite(beingHit);
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
    }
}