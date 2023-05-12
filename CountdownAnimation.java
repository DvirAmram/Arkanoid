import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    /**
     * constructor.
     * @param numOfSeconds
     * @param countFrom
     * @param gameScreen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen){
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        long millisecondsPerFrame = (long) ((numOfSeconds/countFrom)*1000);
        Sleeper sleeper = new Sleeper();
        if (this.countFrom < 3) {
            sleeper.sleepFor(millisecondsPerFrame);
        }
        d.setColor(new Color(51, 153, 78));
        if (this.countFrom != 0) {
            d.drawText(400, 300, "" + this.countFrom, 33);
        }
        else {
            d.drawText(400, 300, "GO", 33);
        }
        this.gameScreen.drawAllOn(d);
        this.countFrom --;
    }
    @Override
    public boolean shouldStop() {
        if (this.countFrom <= 0){
            return true;
        }
        return false;
    }
}