/*
 * 318192200
 * Dvir Amram
 * Line
 */

import java.util.List;

/**
 * A class creates an object that describes a line on a plane by two points.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        this(start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * constructor.
     *
     * @param x1 = X value of the first point
     * @param y1 = Y value of the first point
     * @param x2 = X value of the second point
     * @param y2 = Y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        // Put in "start" the point with the smaller "X" value
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Calculate the length of the line.
     *
     * @return length of the line
     */
    public double length() {
        return (this.start.distance(this.end));
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
     * Calculate middle point.
     *
     * @return the point exactly in the middle of the line
     */
    public Point middle() {
        // avg of x's
        double x = (this.start.getX() + this.end.getX()) / 2.0;
        //avg of y's
        double y = (this.start.getY() + this.end.getY()) / 2.0;
        Point middle = new Point(x, y);
        return middle;
    }

    /**
     * access to start point.
     *
     * @return start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * access to end point.
     *
     * @return end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Check if the line is vertical.
     *
     * @return true/false
     */
    public boolean ifVertical() {
        if (equal(this.start.getX(), this.end.getX()) && !equal(this.start.getY(), this.end.getY())) {
            return true;
        }
        return false;
    }

    /**
     * the function get point and check if the point on the line or not.
     *
     * @param p = point to check
     * @return true/false
     */
    public boolean ifPointOnLine(Point p) {
        // in case the line is actually a point
        if (this.start.equals(this.end)) {
            if (this.start.equals(p)) {
                return true;
            }
        }
        // in case the line is not vertical, Check if the dot satisfies the equation of the line
        if (!(this.ifVertical())) {
            LinearFunction line = new LinearFunction(this);
            double x = p.getX();
            // check if tha point on the line range
            if (line.ifPointOnLine(p)) {
                if (((this.start.getX() <= x) && (x <= this.end.getX())) || ((this.end.getX() <= x)
                        && (x <= this.start.getX()))) {
                    return true;
                }
            }
            return false;
        } else {
            // in case the line is vertical - we cant use linear function
            if (equal(p.getX(), this.start.getX())) {
                double y = p.getY();
                if (((this.start.getY() <= y) && (y <= this.end.getY())) || ((this.end.getY() <= y)
                        && (y <= this.start.getY()))) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * The function checks if the two lines intersect. If so it returns their point of intersection,
     * otherwise it returns null
     *
     * @param other Line to check
     * @return intersection point
     */
    public Point intersectionWith(Line other) {
        // If the two lines are not a point
        if ((!(this.start.equals(this.end))) && (!(other.start().equals(other.end())))) {
            // and two lines are not a vertical
            if (!this.ifVertical() && !other.ifVertical()) {
                LinearFunction ourLine = new LinearFunction(this);
                LinearFunction otherLine = new LinearFunction(other);
                //if the line intersect
                if (ourLine.parallelIntersectingOrConverge(otherLine) == 1) {
                    Point intersectingPoint = ourLine.intersectionPoint(otherLine);
                    // and the intersectingPoint on both line
                    if (this.ifPointOnLine(intersectingPoint) && other.ifPointOnLine(intersectingPoint)) {
                        // return intersectingPoint
                        return ourLine.intersectionPoint(otherLine);
                    } else {
                        return null;
                    }
                    //if the line parallel
                } else {
                    if (ourLine.parallelIntersectingOrConverge(otherLine) == 0) {
                        return null;
                    } else {
                        // if the line consolidate
                        //If the straight meet at the edge
                        if (this.start.equals(other.end()) || this.end.equals(other.start())) {
                            if (this.start.equals(other.end())) {
                                return this.start;
                            } else {
                                return this.end;
                            }
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                // if one of the line is vertical
                // if the both lines are vertical
                if (this.ifVertical() && other.ifVertical()) {
                    //If the straight meet at the edge
                    if (this.start.equals(other.end()) || this.end.equals(other.start())) {
                        if (this.start.equals(other.end())) {
                            return this.start;
                        } else {
                            return this.end;
                        }
                    } else {
                        return null;
                    }
                } else {
                    // if just one line is vertical
                    // if our line is vertical
                    if (this.ifVertical()) {
                        LinearFunction otherLine = new LinearFunction(other);
                        double y = otherLine.yAccordingToX(this.start.getX());
                        Point p = new Point(this.start.getX(), y);
                        // check if other line between our line edges
                        if (this.ifPointOnLine(p) && other.ifPointOnLine(p)) {
                            return p;
                        } else {
                            return null;
                        }
                    } else {
                        // if other line is vertical
                        LinearFunction ourLine = new LinearFunction(this);
                        double y = ourLine.yAccordingToX(other.start().getX());
                        Point p = new Point(other.start().getX(), y);
                        // check if our line between other line edges
                        if (this.ifPointOnLine(p) && other.ifPointOnLine(p)) {
                            return p;
                        } else {
                            return null;
                        }
                    }

                }
            }
        } else {
            // if one of the line is a point (start = and)
            //if both line are point
            if (this.start.equals(this.end) && other.start().equals(other.end())) {
                //check if the two point are the same
                if (this.start.equals(other.start())) {
                    return this.start;
                } else {
                    return null;
                }
            } else {
                // if just our line is a point
                if (this.start.equals(this.end)) {
                    LinearFunction otherLine = new LinearFunction(other);
                    // Check if the point on the line
                    if (otherLine.ifPointOnLine(this.start)) {
                        double x = this.start.getX();
                        double x1 = other.end().getX();
                        double x2 = other.start().getX();
                        if (((x <= x1) && (x >= x2)) || ((x <= x2) && (x >= x1))) {
                            return this.start;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    // if just other line is a point
                    LinearFunction ourLine = new LinearFunction(this);
                    if (ourLine.ifPointOnLine(other.start())) {
                        double x = other.start().getX();
                        double x1 = this.end.getX();
                        double x2 = this.start.getX();
                        // Check if the point on the line
                        if (((x <= x1) && (x >= x2)) || ((x <= x2) && (x >= x1))) {
                            return other.start();
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
            }
        }
    }

    /**
     * Check if our line isIntersecting with other line.
     *
     * @param other = other line to compare with
     * @return true / false
     */
    public boolean isIntersecting(Line other) {
        Line ourLine = new Line(this.start, this.end);
        // if there is a intersection point
        if (ourLine.intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * Check if our line is the same like other line.
     *
     * @param other = other line to compare with
     * @return true / false
     */
    public boolean equals(Line other) {
        if ((this.start.equals(other.start()) && this.end.equals(other.end())) || (this.start.equals(other.end())
                && this.end.equals(other.start()))) {
            return true;
        }
        return false;
    }

    /**
     * return the closest Intersection point To the Start Of the Line.
     *
     * @param rect = given Rectangle to check with
     * @return intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // get all the intersectionPoints
        List<Point> lst = rect.intersectionPoints(this);
        // if there is no intersectionPoints
        if (lst.isEmpty()) {
            return null;
        }
        // if just one
        if (lst.size() == 1) {
            return lst.get(0);
        }
        // if two, return the closest
        if (lst.get(0).distance(this.start) <= lst.get(1).distance(this.start)) {
            return lst.get(0);
        } else {
            return lst.get(1);
        }
    }
}
