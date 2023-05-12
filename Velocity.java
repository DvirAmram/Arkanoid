/*
 * 318192200
 * Dvir Amram
 * Velocity
 */

/**
 * A class creates an object that describes velocity of movement according to dx and dy values.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx given dx
     * @param dy given dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Update point location.
     *
     * @param p given point
     * @return new location
     */
    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() - this.dy);
        return point;
    }

    /**
     * access to dx.
     *
     * @return dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * access to dy.
     *
     * @return dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * compare between two Velocities.
     *
     * @param other = other velocity to compare with
     * @return 1 if ourSpeed > otherSpeed, 0 if ourSpeed == otherSpeed, -1 if ourSpeed < otherSpeed
     */
    public int compareVelocity(Velocity other) {
        double ourSpeed = Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
        double otherSpeed = Math.sqrt(Math.pow(other.getDx(), 2) + Math.pow(other.getDy(), 2));
        if (ourSpeed > otherSpeed) {
            return 1;
        }
        if (ourSpeed == otherSpeed) {
            return 0;
        }
        return -1;
    }

    /**
     * Absolute value of velocity vector.
     * @return speed
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * create velocity by Angle And Speed.
     *
     * @param angle given parameter
     * @param speed given parameter
     * @return new velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dy = Math.sin((Math.PI / 2) - angle) * speed;
        double dx = Math.sin(angle) * speed;
        return new Velocity(dx, dy);
    }
}
