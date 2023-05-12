/*
 * 318192200
 * Dvir Amram
 * ScoreIndicator
 */

import biuoop.DrawSurface;

/**
 * The department defines a sprite that aims to present the player's score at the top of the surface.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener score;

    /**
     * constructor.
     *
     * @param score - the player's score
     */
    public ScoreIndicator(ScoreTrackingListener score) {
        this.score = score;
    }

    /**
     * write the score on the surface.
     *
     * @param d - the surface
     */
    public void drawOn(DrawSurface d) {
        d.drawText(350, 20, "Score: " + this.score.getCurrentScore().getValue(), 18);
    }

    /**
     * do nothing.
     */
    public void timePassed() {
    }
}
