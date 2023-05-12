/*
 * 318192200
 * Dvir Amram
 * LinearFunction
 */

/**
 * A class creates an object that describes a Linear Function on a plane by line.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */

public class LinearFunction {
    private double slope;
    private double yIntercept;

    /**
     * constructor.
     *
     * @param l line
     */
    public LinearFunction(Line l) {
        this.slope = (l.start().getY() - l.end().getY()) / (l.start().getX() - l.end().getX());
        this.yIntercept = (-1.0) * this.slope * (l.start().getX()) + l.start().getY();
    }

    /**
     * access to slope.
     *
     * @return slope
     */
    public double getSlope() {
        return this.slope;
    }

    /**
     * access to YIntercept.
     *
     * @return YIntercept
     */
    public double getYIntercept() {
        return this.yIntercept;
    }

    /**
     * The function gets 2 numbers,
     * Returns true if the difference between them is negligible.
     * And false otherwise.
     *
     * @param a = first value
     * @param b = second value
     * @return true/false
     */
    public boolean equal(double a, double b) {
        double epsilon = Math.pow(10, -6);
        if (Math.abs(a - b) < epsilon) {
            return true;
        }
        return false;
    }

    /**
     * The function checks if two lines are parallel, Intersecting or Converge.
     *
     * @param other line
     * @return 1 for Intersecting, 0 for parallel, -1 for Converge
     */
    public int parallelIntersectingOrConverge(LinearFunction other) {
        if (equal(this.slope, other.slope)) {
            if (equal(this.yIntercept, other.yIntercept)) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    /**
     * the function return the intersectionPoint between our line to other line.
     *
     * @param other line
     * @return intersection Point
     */
    public Point intersectionPoint(LinearFunction other) {
        double x = (this.yIntercept - other.yIntercept) / (other.slope - this.slope);
        double y = this.slope * x + this.yIntercept;
        Point p = new Point(x, y);
        return p;
    }

    /**
     * @param x of point
     * @return y value according to x
     */
    public double yAccordingToX(double x) {
        return (this.slope * x + this.yIntercept);
    }

    /**
     * @param y of point
     * @return x value according to y
     */
    public double xAccordingToY(double y) {
        return ((y - this.yIntercept) / this.slope);
    }

    /**
     * @param p point to check
     * @return true if p on the line, and false otherwise.
     */
    public boolean ifPointOnLine(Point p) {
        if (equal(this.slope * p.getX() + this.yIntercept, p.getY())) {
            return true;
        }
        return false;
    }
}
