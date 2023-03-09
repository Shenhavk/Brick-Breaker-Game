package Default;
import Shapes.Point;

/**
 * Shenhav Katzav id: 209190560.
 * class Velocity
 * class for velocity of ball. members are dx (movement of ball on x) and dy (movement of ball on y)
 */

public class Velocity {
    private double dx; // movement of ball on x
    private double dy; // movement of ball on y

    /**
     * @param dx for movement of the ball on x
     * @param dy for movement of the ball on y
     * constructor
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return speed of the ball
     * this function is calculating the speed of this velocity
     * according to dx and dy and returning it
     */
    public double getSpeed() {
        return Math.sqrt((this.dx * this.dx) + (this.dy * this.dy));
    }
    /**
     * @return dx value
     * this function is returning dx value of this velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @param dx given movement of ball on x
     * this function is setting dx of this velocity to a given dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }
    /**
     * @return dy value
     * this function is returning dy value of this velocity
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * @param dy given movement of ball on y
     * this function is setting dy of this velocity to a given dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * @param p given point
     * @return new point with position (x+dx, y+dy)
     * this function takes a point with position (x, y)
     * and return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        double newX = (p.getX() + dx);
        double newY = (p.getY() + dy);
        return new Point(newX, newY);
    }

    /**
     * @param angle of movement of a ball
     * @param speed of a ball
     * @return new velocity according to the given angle and speed
     * this function gets angle of movement and speed
     * and calculating velocity according to the given values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx, dy;
        dx = (speed * Math.sin(Math.toRadians(angle))); // calculating dx
        dy = -(speed * Math.cos(Math.toRadians(angle))); // calculating dy
        return new Velocity(dx, dy);
    }
}