/*
 * 318192200
 * Dvir Amram
 * Animation
 */
import biuoop.DrawSurface;
/**
 * An interface that each class that implements will be animated.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public interface Animation {

    /**
     * Show frame.
     * @param d - the surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * return true if the animation should stop, and false otherwise.
     * @return true/false
     */
    boolean shouldStop();
}
