package Shapes;
/**
 * Shenhav Katzav id: 209190560.
 * class Line
 * class for line on the screen. members are start point and end point
 */
public class Line {
    private final Point start; // start point of the line
    private final Point end; // end point of the line
    static final double EPSILON = Math.pow(10, -10); // EPSILON

    /**
     * @param start of the line
     * @param end of the line
     * constructor
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param x1 value of the start point
     * @param y1 value of the start point
     * @param x2 value of the end point
     * @param y2 value of the end point
     * constructor
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.start = start;
        this.end = end;
    }
    /**
     * @return length of the line
     * this function is calculating the length of the line and returns it
     */
    public double length() {
        return this.end.distance(this.start); // calculating distance between end point and start point
    }
    /**
     * @return middle point of the line
     * this function is calculating the middle point of the line and returns it
     */
    public Point middle() {
        Point middle;
        double middleX = (this.end.getX() + this.start.getX()) / 2; // calculating middle x value
        double middleY = (this.end.getY() + this.start.getY()) / 2; // calculating middle y value
        middle = new Point(middleX, middleY);
        return middle;

    }
    /**
     * @return start point of the line
     * this function is returning the start point of the line
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return end point of the line
     * this function is returning the end point of the line
     */
    public Point end() {
        return this.end;
    }
    /**
     * @param other line to check if intersecting with this line
     * @return true if intersecting, otherwise false
     * this function is checking if this line is intersecting with a given line
     * if so returns true, otherwise returns false
     */
    public boolean isIntersecting(Line other) {
        return !(this.intersectionWith(other) == null);
    }
    /**
     * @param other - given line
     * @return the intersection point if the lines intersect, and null otherwise
     * this function is checking if this line intersect with a given line.
     * if so, returns the intersection point, otherwise returns null
     */
    public Point intersectionWith(Line other) {
        Point interPoint;
        double incline, yIntersection, x, y;
        if (this.start.getX() == this.end.getX()) {
            if (other.start.getX() == other.end.getX()) {
                interPoint = func1(other);
            } else if (other.start.getY() == other.end.getY()) {
                interPoint = new Point(this.start.getX(), other.start.getY());
            } else {
                incline = other.incline();
                yIntersection = other.intersectionWithY();
                x = this.start.getX();
                y = (incline * x) + yIntersection;
                interPoint = new Point(x, y);
            }
        } else if (other.start.getX() == other.end.getX()) {
            if (this.start.getX() == this.end.getX()) {
                interPoint = func1(other);
            } else if (this.start.getY() == this.end.getY()) {
                interPoint = new Point(other.start.getX(), this.start.getY());
            } else {
                incline = this.incline();
                yIntersection = this.intersectionWithY();
                x = other.start.getX();
                y = (incline * x) + yIntersection;
                interPoint = new Point(x, y);
            }
        } else if (this.start.getY() == this.end.getY()) {
            if (other.start.getY() == other.end.getY()) {
                interPoint = func2(other);
            } else if (other.start.getX() == other.end.getX()) {
                interPoint = new Point(other.start.getX(), this.start.getY());
            } else {
                incline = other.incline();
                yIntersection = other.intersectionWithY();
                y = this.start.getY();
                x = (y - yIntersection) / incline;
                interPoint = new Point(x, y);
            }
        } else if (other.start.getY() == other.end.getY()) {
            if (this.start.getY() == this.end.getY()) {
                interPoint = func2(other);
            } else if (this.start.getX() == this.end.getX()) {
                interPoint = new Point(this.start.getX(), other.start.getY());
            } else {
                incline = this.incline();
                yIntersection = this.intersectionWithY();
                y = other.start.getY();
                x = (y - yIntersection) / incline;
                interPoint = new Point(x, y);
            }
        } else {
            if (this.incline() == other.incline()) {
                if (this.start.getX() == other.start.getX()) {
                    interPoint = new Point(this.start.getX(), this.start.getY());
                } else if (this.end.getX() == other.end.getX()) {
                    interPoint = new Point(this.end.getX(), this.end.getY());
                } else if (this.start.getX() == other.end.getX()) {
                    interPoint = new Point(this.start.getX(), this.start.getY());
                } else if (other.start.getX() == this.end.getX()) {
                    interPoint = new Point(other.start.getX(), other.start.getY());
                } else {
                    interPoint = null;
                }
            } else {
                incline = this.incline();
                double anotherIncline = other.incline();
                yIntersection = this.intersectionWithY();
                double anotherYInter = other.intersectionWithY();
                x = (anotherIncline - incline) / (yIntersection - anotherYInter);
                y = (incline * x) + yIntersection;
                interPoint = new Point(x, y);
            }
        }
        if (this.isOnLine(interPoint) && other.isOnLine(interPoint)) {
            return interPoint;
        }
        return null;
    }


    /**
     * @param other - given line
     * @return the intersection point if the lines intersect, and null otherwise
     * this function is checking for vertical lines if there is intersection
     * between them. if so, returns the intersection point, otherwise returns null.
     */
    public Point func1(Line other) {
        Point interPoint;
        if (this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY()) {
            interPoint = new Point(this.end.getX(), this.end.getY());
            return interPoint;
        } else if (other.end.getX() == this.start.getX() && other.end.getY() == this.start.getY()) {
            interPoint = new Point(this.start.getX(), this.start.getY());
            return interPoint;
        } else if (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY()) {
            interPoint = new Point(this.end.getX(), this.end.getY());
            return interPoint;
        } else if (other.start.getX() == this.start.getX() && this.start.getY() == other.start.getY()) {
            interPoint = new Point(this.start.getX(), this.start.getY());
            return interPoint;
        }
        return null;
    }

    /**
     * @param other - given line
     * @return the intersection point if the lines intersect, and null otherwise
     * this function is checking for horizontal lines if there is intersection
     * between them. if so, returns the intersection point, otherwise returns null.
     */
    public Point func2(Line other) {
        Point interPoint;
        if (this.end.getY() == other.start.getY() && this.end.getX() == other.start.getX()) {
            interPoint = new Point(this.end.getX(), this.end.getY());
            return interPoint;
        } else if (other.end.getY() == this.start.getY() && this.start.getX() == other.end.getX()) {
            interPoint = new Point(this.start.getX(), this.start.getY());
            return interPoint;
        } else if (this.end.getY() == other.end.getY() && this.end.getX() == other.end.getX()) {
            interPoint = new Point(this.end.getX(), this.end.getY());
            return interPoint;
        } else if (other.start.getY() == this.start.getY() && this.start.getX() == other.start.getX()) {
            interPoint = new Point(this.start.getX(), this.start.getY());
            return interPoint;
        }
        return null;
    }
    /**
     * @param other point to check
     * @return true if the point is on the line, otherwise false
     * this function is checking if a given point is on this line
     * if so returns true, otherwise returns false
     */
    public boolean isOnLine(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs(this.start.distance(other) + this.end.distance(other) - this.length()) <= EPSILON;
    }
    /**
     * @return incline of this line
     * this function is calculating this line's incline and returns it
     */

    public double incline() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()); // return incline
    }
    /**
     * @return intersection point of this line with y
     * this function is calculating this line's intersection point with y and returns it
     */
    public double intersectionWithY() {
        double m = this.incline(); // incline of this line with incline function
        return -1 * (m * this.start.getX()) + this.start.getY(); // calculating the intersection point
    }
    /**
     * @param other line to check if this line equals to
     * @return true if the lines are equal, otherwise false
     * this function is checking if this line equals to other line
     * if so returns true, otherwise returns false
     */
    public boolean equals(Line other) {
        return ((this.incline() == other.incline()) && (this.intersectionWithY() == other.intersectionWithY())
                && (this.length() == other.length()));
    }

    /**
     * @param rect - given rectangle
     * @return intersection point if there is, otherwise null
     * this function checks if the line intersect with the given rectangle.
     * if not, return null. otherwise return the closest intersection point
     * to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersections = rect.intersectionPoints(this);
        if (intersections.isEmpty()) { // if there are no intersection points
            return null;
        }

        Point theClosest = intersections.get(0);
        for (int i = 1; i < intersections.size(); i++) { // checking for the closest point
            if (this.start.distance(theClosest) > this.start.distance(intersections.get(i))) {
                theClosest = intersections.get(i);
            }
        }
        return theClosest;
    }
}