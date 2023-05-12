/*
 * 318192200
 * Dvir Amram
 * KeyPressStoppableAnimation
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Ability to stop showing animation by pressing a key on the keyboard.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;

    /**
     * constructor.
     *
     * @param sensor    the Keyboard
     * @param key       the key
     * @param animation the animation to stop
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        this.stop = false;
    }

    @Override
    public boolean shouldStop() {
        if (this.sensor.isPressed(this.key) && !this.stop) {
            return true;
        }
        return false;
    }
}
