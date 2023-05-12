/*
 * 318192200
 * Dvir Amram
 * Rectangle
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The class defines rectangle on the plane.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * access to width.
     *
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * update UpperLeft point.
     *
     * @param p point
     */
    public void setUpperLeft(Point p) {
        this.upperLeft = p;
    }

    /**
     * access to height.
     *
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * access to uper left point.
     *
     * @return upperLeft
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the function return list of intersection point between the line and the rectangle.
     *
     * @param line to check with
     * @return list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> lst = new ArrayList<>();
        Point p1 = line.intersectionWith(this.upperEdge());
        Point p2 = line.intersectionWith(this.bottomEdge());
        Point p3 = line.intersectionWith(this.rightEdge());
        Point p4 = line.intersectionWith(this.leftEdge());
        // if there is intersection point add it to the list
        if (p1 != null) {
            lst.add(p1);
        }
        if (p2 != null) {
            lst.add(p2);
        }
        if (p3 != null) {
            lst.add(p3);
        }
        if (p4 != null) {
            lst.add(p4);
        }
        return lst;
    }

    /**
     * access to the UpperRight vertex.
     *
     * @return UpperRight vertex
     */
    public Point getUpperRight() {
        double x = this.upperLeft.getX() + this.width;
        double y = this.upperLeft.getY();
        return new Point(x, y);
    }

    /**
     * access to the BottomLeft vertex.
     *
     * @return BottomLeft vertex
     */
    public Point getBottomLeft() {
        double x = this.upperLeft.getX();
        double y = this.upperLeft.getY() + this.height;
        return new Point(x, y);
    }

    /**
     * access to the BottomRight vertex.
     *
     * @return BottomRight vertex
     */
    public Point getBottomRight() {
        double x = this.upperLeft.getX() + this.width;
        double y = this.upperLeft.getY() + this.height;
        return new Point(x, y);
    }

    /**
     * access to the upperEdge.
     *
     * @return upperEdge
     */
    public Line upperEdge() {
        Point start = this.upperLeft;
        Point end = this.getUpperRight();
        return new Line(start, end);
    }

    /**
     * access to the bottomEdge.
     *
     * @return bottomEdge
     */
    public Line bottomEdge() {
        Point start = this.getBottomRight();
        Point end = this.getBottomLeft();
        return new Line(start, end);
    }

    /**
     * access to the leftEdge.
     *
     * @return leftEdge
     */
    public Line leftEdge() {
        Point start = this.upperLeft;
        Point end = this.getBottomLeft();
        return new Line(start, end);
    }

    /**
     * access to the rightEdge.
     *
     * @return rightEdge
     */
    public Line rightEdge() {
        Point start = this.getUpperRight();
        Point end = this.getBottomRight();
        return new Line(start, end);
    }


}
