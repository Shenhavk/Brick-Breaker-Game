package Shapes;
/**
 * Shenhav Katzav id: 209190560.
 * class Point
 * class for point on the screen. members for point are x value and y value
 */
public class Point {
    private double x; // x value of the point
    private double y; // y value of the point

    /**
     * @param x x of the point
     * @param y y of the point
     * constructor
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other point to calculate the distance from this point
     * @return the distance between this point to other
     * this function is calculating the distance between this point to a given point and returns it
     */
    public double distance(Point other) {
        double otherX = other.getX();
        double otherY = other.getY();
        return Math.sqrt(((this.x - otherX) * (this.x - otherX)) + ((this.y - otherY) * (this.y - otherY)));
    }

    /**
     * @param other point to check if equals to this point
     * @return true if the points are equal, otherwise false
     * this function is checking if this point equals to a given other point,
     * if so returns true, otherwise returns false.
     */
    public boolean equals(Point other) {
        double otherX = other.getX();
        double otherY = other.getY();
        return ((this.x == otherX) && (this.y == otherY));
    }
    /**
     * @return x value of this point
     * this function is returning the x value of this point
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return y value of this point
     * this function is returning the y value of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x value to update for this point
     * this function updates the x value of this point to a given x value
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * @param y value to update for this point
     * this function updates the y value of this point to a given y value
     */
    public void setY(double y) {
        this.y = y;
    }
}