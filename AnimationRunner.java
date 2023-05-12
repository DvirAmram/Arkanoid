/*
 * 318192200
 * Dvir Amram
 * AnimationRunner
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Animation Runner.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    /**
     * constructor.
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        ;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * run the animation loop.
     *
     * @param animation the animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * access to GUI.
     *
     * @return GUI
     */
    public GUI getGui() {
        return this.gui;
    }
}