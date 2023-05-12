/*
 * 318192200
 * Dvir Amram
 * WinnerScreen
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the screen that showed up if player win.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class WinnerScreen implements Animation {
    private KeyboardSensor keyboard;
    private int score;

    /**
     * constructor.
     *
     * @param k   the Keyboard
     * @param scr the final score.
     */
    public WinnerScreen(KeyboardSensor k, Counter scr) {
        this.keyboard = k;
        this.score = scr.getValue();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is:" + this.score, 30);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}