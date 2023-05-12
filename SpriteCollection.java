/*
 * 318192200
 * Dvir Amram
 * SpriteCollection
 */

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The class defines list of object that need to change location during the game.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class SpriteCollection {
    private List<Sprite> lst;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.lst = new ArrayList<>();
    }

    /**
     * add object to the list.
     *
     * @param s the object
     */
    public void addSprite(Sprite s) {
        this.lst.add(s);
    }

    /**
     * change all the objects location.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.lst.size(); i++) {
            this.lst.get(i).timePassed();
        }
    }

    /**
     * draw all object.
     *
     * @param d the surface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.lst.size(); i++) {
            this.lst.get(i).drawOn(d);
        }
    }

    /**
     * access to the list.
     *
     * @return the list
     */
    public List<Sprite> getLst() {
        return this.lst;
    }
}
