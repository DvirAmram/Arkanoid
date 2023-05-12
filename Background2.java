/*
 * 318192200
 * Dvir Amram
 * Background2
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background of the second level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Background2 implements Sprite {
    /**
     * constructor.
     */
    public Background2() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        // drawing the picture.
        d.setColor(Color.yellow);
        for (int i = 2; i <= 70; i++) {
            d.drawLine(200, 150, i * 10, 250);
        }
        d.setColor(Color.yellow);
        d.fillCircle(200, 150, 70);
        d.setColor(Color.ORANGE);
        d.fillCircle(200, 150, 60);
        d.setColor(Color.YELLOW);
        d.fillCircle(200, 150, 50);
    }


    @Override
    public void timePassed() {
    }
}