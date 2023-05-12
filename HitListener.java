/*
 * 318192200
 * Dvir Amram
 * HitListener
 */

/**
 * An interface that objects from any class that implements it will will serve as a listener for hit -
 * it will know when there is an hit between a ball and a block.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit - the block
     * @param hitter   - the ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}