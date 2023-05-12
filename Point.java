/*
 * 318192200
 * Dvir Amram
 * Point
 */

/**
 * A class creates an object that describes a point on a plane by x and y values.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x = The value of x
     * @param y = The value of y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculation of distance between 2 points by distance formula.
     *
     * @param other = Another point
     * @return = The distance between our point, to the point "other".
     */
    public double distance(Point other) {
        return (Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2)));
    }

    /**
     * The function gets 2 numbers,
     * Returns true if the difference between them is negligible
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
     * Check if two Point are the same.
     *
     * @param other = the other Point
     * @return true/false
     */
    public boolean equals(Point other) {
        if ((equal(this.x, other.getX())) && (equal(this.y, other.getY()))) {
            return true;
        }
        return false;
    }

    /**
     * access to x.
     *
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * access to y.
     *
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * update x value.
     *
     * @param x0 = given parameter.
     */
    public void setX(double x0) {
        this.x = x0;
    }

    /**
     * update y value.
     *
     * @param y0 = given parameter.
     */
    public void setY(double y0) {
        this.y = y0;
    }
}
