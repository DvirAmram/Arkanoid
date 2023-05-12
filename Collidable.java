/*
 * 318192200
 * Dvir Amram
 * Velocity
 */

/**
 * An interface that will contain classes that describe objects that a ball can collide with.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public interface Collidable {
    /**
     * access to hitten rectangle.
     *
     * @return rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  collision Point
     * @param currentVelocity current Velocity
     * @param hitter          the ball.
     * @return new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
