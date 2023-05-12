/*
 * 318192200
 * Dvir Amram
 * GameEnvironment
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The class save the objects in the game environment in a list.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class GameEnvironment {
    private List<Collidable> lst;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.lst = new ArrayList<>();
    }

    /**
     * adding new object to the list.
     *
     * @param c - the object
     */
    public void addCollidable(Collidable c) {
        this.lst.add(c);
    }

    /**
     * access to the list.
     *
     * @return the list
     */
    public List<Collidable> getLst() {
        return this.lst;
    }

    /**
     * the function give information about the closest collision of the ball.
     *
     * @param trajectory - Vector describing the movement of the ball
     * @return information about the collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collision = new ArrayList<>();
        // add all the possible collision to the list
        for (int i = 0; i < this.lst.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(this.lst.get(i).getCollisionRectangle()) != null) {
                collision.add(this.lst.get(i));
            }
        }
        // if there is no collision soon,
        if (collision.isEmpty()) {
            return null;
        }
        int index = 0;
        double min = trajectory.start().distance(trajectory.closestIntersectionToStartOfLine(collision.get(index).
                getCollisionRectangle()));
        //check who is the closest
        for (int i = 1; i < collision.size(); i++) {
            double currentDistance = trajectory.start().distance(trajectory.closestIntersectionToStartOfLine((collision.
                    get(i).getCollisionRectangle())));
            if (min > currentDistance) {
                min = currentDistance;
                index = i;
            }
        }
        // return the information
        return new CollisionInfo(trajectory.closestIntersectionToStartOfLine(collision.get(index).
                getCollisionRectangle()), collision.get(index));

    }

}
