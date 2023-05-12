/*
 * 318192200
 * Dvir Amram
 * Background4
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background of the fourth level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Background4 implements Sprite {

    /**
     * constructor.
     */
    public Background4() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        // drawing the picture
        d.setColor(new Color(33, 140, 231));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(70, 450, 40);
        d.fillCircle(120, 450, 40);
        d.fillCircle(160, 450, 40);
        d.fillCircle(95, 470, 40);
        d.fillCircle(140, 470, 40);
        for (int i = 0; i <= 9; i++) {
            d.drawLine(50 + 13 * i, 450, 50 + 11 * i, 600);
        }
        d.fillCircle(570, 250, 40);
        d.fillCircle(620, 250, 40);
        d.fillCircle(660, 250, 40);
        d.fillCircle(595, 270, 40);
        d.fillCircle(640, 270, 40);
        for (int i = 0; i <= 9; i++) {
            d.drawLine(570 + 13 * i, 250, 590 + 11 * i, 600);
        }

    }


    @Override
    public void timePassed() {
    }
}