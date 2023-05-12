/*
 * 318192200
 * Dvir Amram
 * CollisionInfo
 */

/**
 * The class creates an object that save th collision data.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class CollisionInfo {
    private Point point;
    private Collidable obj;

    /**
     * constructor.
     *
     * @param point collision point
     * @param obj   The object they collided with
     */
    public CollisionInfo(Point point, Collidable obj) {
        this.point = point;
        this.obj = obj;
    }

    /**
     * access to the collision point.
     *
     * @return collisionPoint
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * access to the object.
     *
     * @return The object they collided with
     */
    public Collidable collisionObject() {
        return this.obj;
    }
}
