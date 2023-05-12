/*
 * 318192200
 * Dvir Amram
 * GameOverScreen
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the screen that showed in losing case.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class GameOverScreen implements Animation {
    private KeyboardSensor keyboard;
    private int score;

    /**
     * constructor.
     *
     * @param k   Keyboard
     * @param scr score
     */
    public GameOverScreen(KeyboardSensor k, Counter scr) {
        this.keyboard = k;
        this.score = scr.getValue();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is:" + this.score, 30);

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
