/*
 * 318192200
 * Dvir Amram
 * Level2
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the second level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Level2 implements LevelInformation {

    /**
     * constructor.
     */
    public Level2() {
    }

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(90 - i * 30, 5);
            ;
            lst.add(v);
        }
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Background2 background = new Background2();
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        // create the blocks
        for (int i = 20; i <= 740; i = i + 40) {
            Rectangle r = new Rectangle(new Point(i, 250), 40, 25);
            if (i == 20 || i == 60) {
                Block b = new Block(r, Color.RED);
                lst.add(b);
            }
            if (i == 100 || i == 140) {
                Block b = new Block(r, Color.ORANGE);
                lst.add(b);
            }
            if (i == 180 || i == 220) {
                Block b = new Block(r, Color.yellow);
                lst.add(b);
            }
            if (i == 260 || i == 300) {
                Block b = new Block(r, Color.green);
                lst.add(b);
            }
            if (i == 340 || i == 380 || i == 420) {
                Block b = new Block(r, Color.blue);
                lst.add(b);
            }
            if (i == 460 || i == 500) {
                Block b = new Block(r, Color.MAGENTA);
                lst.add(b);
            }
            if (i == 540 || i == 580) {
                Block b = new Block(r, Color.pink);
                lst.add(b);
            }
            if (i == 620 || i == 660) {
                Block b = new Block(r, Color.cyan);
                lst.add(b);
            }
            if (i == 700 || i == 740) {
                Block b = new Block(r, Color.lightGray);
                lst.add(b);
            }

        }
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}