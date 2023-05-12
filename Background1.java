/*
 * 318192200
 * Dvir Amram
 * Background1
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background of the first level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Background1 implements Sprite {

    /**
     * constructor.
     */
    public Background1() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        // drawing the picture
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        for (int i = 20; i <= 60; i = i + 20) {
            d.drawCircle(400, 100, i);
        }
        d.drawLine(400, 35, 400, 85);
        d.drawLine(400, 115, 400, 165);
        d.drawLine(335, 100, 385, 100);
        d.drawLine(415, 100, 465, 100);
    }

    @Override
    public void timePassed() {
    }
}
