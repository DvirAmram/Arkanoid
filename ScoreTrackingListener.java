/*
 * 318192200
 * Dvir Amram
 * ScoreTrackingListener
 */

/**
 * Score counter and hit listener.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter - the Score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
        ;
    }

    /**
     * access to current Score.
     *
     * @return currentScore
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }
}