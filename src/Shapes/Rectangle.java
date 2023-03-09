package Shapes;
import java.util.ArrayList;
/**
 * Shenhav Katzav id: 209190560.
 * class Rectangle
 * class for Rectangle. members are upper left point, width, and height.
 */
public class Rectangle {
    private Point upperLeft;
    private final double width;
    private final double height;

    /**
     * @param upperLeft - given upper left point
     * @param width - given width of the rectangle
     * @param height - given height of the rectangle
     * constructor.
     * create a new rectangle, with location and width, height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @param upperLeft - given upper left point
     * this function is updating the upper left point (location) of the
     * rectangle according to a given point.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * @param line - a given line
     * @return list of intersection points with the given line (can be empty line)
     * this function is checking if there are intersection points between this rectangle
     * to a given line, and returns a list of these points.
     * if there are no points, returns empty list.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        boolean isAdd = true;
        java.util.List<Point> intersections = new ArrayList<>();
        Line upLine = new Line(this.upperLeft, this.getUpperRight());
        Line downLine = new Line(this.getDownerLeft(), this.getDownerRight());
        Line leftLine = new Line(this.upperLeft, this.getDownerLeft());
        Line rightLine = new Line(this.getUpperRight(), this.getDownerRight());
        if (line.isIntersecting(upLine)) { // for the upper line of the rectangle
            Point p1 = line.intersectionWith(upLine);
            intersections.add(p1);
        }
        if (line.isIntersecting(downLine)) { // for the down line of the rectangle
            Point p1 = line.intersectionWith(downLine);
            for (Point inter : intersections) {
                if (inter.equals(p1)) {
                    isAdd = false;
                }
            }
            if (isAdd) {
                intersections.add(p1);
            }
        }
        if (line.isIntersecting(rightLine)) { // for the right line of the rectangle
            Point p1 = line.intersectionWith(rightLine);
            for (Point inter : intersections) {
                if (inter.equals(p1)) {
                    isAdd = false;
                }
            }
            if (isAdd) {
                intersections.add(p1);
            }
        }
        if (line.isIntersecting(leftLine)) { // for the left line of the rectangle
            Point p1 = line.intersectionWith(leftLine);
            for (Point inter : intersections) {
                if (inter.equals(p1)) {
                    isAdd = false;
                }
            }
            if (isAdd) {
                intersections.add(p1);
            }
        }
        return intersections;
    }

    /**
     * @return - upper right point of this rectangle
     * this function is returning the upper right point of this rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
    }
    /**
     * @return - downer left point of this rectangle
     * this function is returning the downer left point of this rectangle.
     */
    public Point getDownerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
    }
    /**
     * @return - downer right point of this rectangle
     * this function is returning the downer right point of this rectangle.
     */
    public Point getDownerRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
    }

    /**
     * @return - width of this rectangle
     * this function is returning the width of this rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return - height of this rectangle
     * this function is returning the height of this rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return - upper left point of this rectangle
     * this function is returning the upper left point of this rectangle.
     * */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}