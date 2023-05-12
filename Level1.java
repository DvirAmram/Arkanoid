/*
 * 318192200
 * Dvir Amram
 * Level1
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the first level of the game.
 *
 * @author Dvir Amram
 * @version 1.0 19 June 2021
 */
public class Level1 implements LevelInformation {

    /**
     * constructor.
     */
    public Level1() {
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        Velocity v = new Velocity(0, 4);
        lst.add(v);
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 6;
    }

    @Override
    public int paddleWidth() {
        return 110;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Background1 background = new Background1();
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        Rectangle r = new Rectangle(new Point(391, 91), 18, 18);
        Block b = new Block(r, Color.RED);
        lst.add(b);
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
