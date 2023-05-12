/*
 * 318192200
 * Dvir Amram
 * Ass3Game
 */

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that run the game using main function.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class Ass6Game {

    /**
     * main function running the game.
     *
     * @param args not using
     */
    public static void main(String[] args) {
        GameFlow game = new GameFlow();
        List<LevelInformation> levels = new ArrayList<>();

        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "1": {
                        levels.add(new Level1());
                        break;
                    }
                    case "2": {
                        levels.add(new Level2());
                        break;
                    }
                    case "3": {
                        levels.add(new Level3());
                        break;
                    }
                    case "4": {
                        levels.add(new Level4());
                        break;
                    }
                }
            }
        }
        if (args.length == 0 || levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        game.runLevels(levels);
    }
}
