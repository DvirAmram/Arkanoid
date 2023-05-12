/*
 * 318192200
 * Dvir Amram
 * Level4
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the fourth level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Level4 implements LevelInformation {


    static final int WIDTH_OF_BLOCK = 40;
    static final int HEIGHT_OF_BLOCK = 20;

    /**
     * constructor.
     */
    public Level4() {
    }

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(90 - 45 * i, 4);
            ;
            lst.add(v);
        }
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 9;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Background4 background = new Background4();
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        //create the blocks
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 18; j++) {
                Color color = new Color(0, 0, 0);
                if (i == 0) {
                    color = Color.GRAY;
                }
                if (i == 1) {
                    color = Color.RED;
                }
                if (i == 2) {
                    color = Color.yellow;
                }
                if (i == 3) {
                    color = Color.GREEN;
                }
                if (i == 4) {
                    color = Color.white;
                }
                if (i == 5) {
                    color = Color.pink;
                }
                if (i == 6) {
                    color = Color.cyan;
                }
                Block b = new Block(new Rectangle(new Point(20 + (j * WIDTH_OF_BLOCK),
                        60 + (i * HEIGHT_OF_BLOCK)), WIDTH_OF_BLOCK,
                        HEIGHT_OF_BLOCK), color);
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