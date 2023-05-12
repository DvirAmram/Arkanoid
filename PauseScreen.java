/*
 * 318192200
 * Dvir Amram
 * PauseScreen
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the screen that showed up if player ask pause.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;

    /**
     * constructor.
     *
     * @param k the Keyboard
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
