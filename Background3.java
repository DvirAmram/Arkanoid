/*
 * 318192200
 * Dvir Amram
 * Background3
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the background of the third level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Background3 implements Sprite {
    /**
     * constructor.
     */
    public Background3() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        // drawing the picture.
        Color color = new Color(125, 171, 201, 255);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(17, 49, 130));
        d.fillCircle(100, 100, 90);
        d.setColor(new Color(48, 75, 141));
        d.fillCircle(200, 200, 50);
        d.setColor(new Color(17, 98, 130));
        d.fillCircle(400, 210, 20);
        d.setColor(new Color(86, 46, 154));
        d.fillCircle(600, 190, 35);
        d.setColor(new Color(17, 130, 126));
        d.fillCircle(100, 400, 8);
        d.setColor(new Color(17, 130, 68));
        d.fillCircle(250, 390, 12);
        d.setColor(new Color(106, 147, 172));
        d.fillCircle(450, 410, 27);
        d.setColor(new Color(0, 60, 215));
        d.fillCircle(600, 560, 62);
        d.setColor(new Color(2, 72, 82));
        d.fillCircle(750, 550, 15);
        d.setColor(new Color(0, 172, 255));
        d.fillCircle(765, 580, 40);
        d.setColor(new Color(75, 43, 179));
        d.fillCircle(700, 300, 40);
    }


    @Override
    public void timePassed() {
    }
}