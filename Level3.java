/*
 * 318192200
 * Dvir Amram
 * Level3
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the third level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Level3 implements LevelInformation {

    static final int WIDTH = 800;
    static final int WIDTH_OF_BORDER = 20;
    static final int WIDTH_OF_BLOCK = 40;
    static final int HEIGHT_OF_BLOCK = 20;
    static final int LAST_BLOCK = WIDTH - WIDTH_OF_BORDER - WIDTH_OF_BLOCK;
    static final int X_FIRST_BLOCK = 300;
    static final int Y_FIRST_BLOCK = 100;

    /**
     * constructor.
     */
    public Level3() {
    }

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        // create the velocities
        for (int i = 1; i <= 2; i++) {
            Velocity v = new Velocity(Math.pow(-1, i) * 5, 6);
            ;
            lst.add(v);
        }
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Blue 3";
    }

    @Override
    public Sprite getBackground() {
        Background3 background = new Background3();
        return background;
    }

    @Override
    public List<Block> blocks() {
        // create the blocks
        List<Block> lst = new ArrayList<>();
        for (int i = X_FIRST_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(14, 59, 127));
            lst.add(b);
        }
        for (int i = X_FIRST_BLOCK + WIDTH_OF_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK + HEIGHT_OF_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(20, 54, 102));
            lst.add(b);
        }
        for (int i = X_FIRST_BLOCK + 2 * WIDTH_OF_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK + 2 * HEIGHT_OF_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(12, 88, 101));
            lst.add(b);
        }
        for (int i = X_FIRST_BLOCK + 3 * WIDTH_OF_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK + 3 * HEIGHT_OF_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(65, 120, 205));
            lst.add(b);
        }
        for (int i = X_FIRST_BLOCK + 4 * WIDTH_OF_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK + 4 * HEIGHT_OF_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(2, 183, 206));
            lst.add(b);
        }
        for (int i = X_FIRST_BLOCK + 5 * WIDTH_OF_BLOCK; i <= LAST_BLOCK; i = i + WIDTH_OF_BLOCK) {
            Block b = new Block(new Rectangle(new Point(i, Y_FIRST_BLOCK + 5 * HEIGHT_OF_BLOCK), WIDTH_OF_BLOCK,
                    HEIGHT_OF_BLOCK), new Color(0, 255, 231));
            lst.add(b);
        }


        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}