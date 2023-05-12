/*
 * 318192200
 * Dvir Amram
 * Velocity
 */

import biuoop.DrawSurface;

/**
 * An interface that will contain classes that describe objects that a change location during th game.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d - the surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
