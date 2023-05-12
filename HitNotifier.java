/*
 * 318192200
 * Dvir Amram
 * HitNotifier
 */

/**
 * An interface that objects from any class that implements it will notify a hit between a ball and a block.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl the object to add
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the object to remove
     */
    void removeHitListener(HitListener hl);
}