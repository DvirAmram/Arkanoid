/*
 * 318192200
 * Dvir Amram
 * GameFlow
 */

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * all the game with all the levels running.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class GameFlow {
    private AnimationRunner ar;
    private Counter score;
    private KeyboardSensor keyboard;

    /**
     * constructor.
     */
    public GameFlow() {
        this.ar = new AnimationRunner();
        this.score = new Counter();
        this.keyboard = this.ar.getGui().getKeyboardSensor();
    }

    /**
     * run the levels one after the other.
     *
     * @param levels - List of the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            // Bring a bonus of one hundred points for passing a level
            if (levels.indexOf(levelInfo) != 0) {
                this.score.increase(100);
            }
            GameLevel level = new GameLevel(levelInfo, this.score, this.ar);
            level.initialize();
            level.run();
            // losing case
            if (level.getNumberOfBalls() == 0) {
                GameOverScreen gameOverScreen = new GameOverScreen(this.keyboard, this.score);
                this.ar.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, gameOverScreen));
                this.ar.getGui().close();
                return;
            }
        }
        // winning case
        WinnerScreen winnerScreen = new WinnerScreen(this.keyboard, this.score);
        this.ar.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, winnerScreen));
        this.ar.getGui().close();
    }
}