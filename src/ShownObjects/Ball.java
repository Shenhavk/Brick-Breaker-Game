package ShownObjects;
import Collids.CollisionInfo;
import Animations.GameLevel;
import Collids.GameEnvironment;
import Default.Velocity;
import Interfaces.Collidable;
import Interfaces.Sprite;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class Ball
 * implements Sprite interface
 * class for ball. members are ball's center point, radius, color, velocity and borders of the frame
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private final Color color;
    private Velocity velocity;
    private Point startOfFrame;
    private Point endOfFrame;
    private GameEnvironment ge;

    /**
     * @param center point of the ball
     * @param r radius of the ball
     * @param color of the ball
     * constructor
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * @param x of the start center point of the ball
     * @param y of the start center point of the ball
     * @param r radius of the ball
     * @param color of the ball
     * constructor
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y); // center start point
        this.r = r;
        this.color = color;
    }

    /**
     * @return x value of the center point of this ball
     * this function is returning the x value of the center point of this ball
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return y value of the center point of this ball
     * this function is returning the y value of the center point of this ball
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return size (radius) of this ball
     * this function is returning the size (radius) of this ball
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return color of this ball
     * this function is returning the color of this ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * @return center point of this ball
     * this function is returning the center point of this ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * @return the game environment of this ball
     * this function is returning the game environment of this ball
     */
    public GameEnvironment getGameEnvironment() {
        return this.ge;
    }

    /**
     * @param ge - given game environment
     * this function is updating the ball's game environment,
     * according to given game environment
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.ge = ge;
    }
    /**
     * this function contains checks for the ball and the ball's radius.
     */
    public void check() {
        // check if the radius is negative
        if (this.r < 0) {
            this.r *= -1;
        }
        // check if the radius is too big for the surface
        if (this.r > Math.max(this.endOfFrame.getX(), this.endOfFrame.getY()) / 2) {
            this.r = (int) Math.max(this.endOfFrame.getX(), this.endOfFrame.getY()) / 2;
        }
        // checking if the radius is 0
        if (this.r == 0) {
            this.r = 10;
        }
        // if the ball is out of frame to left
        if (this.center.getX() - this.r < this.startOfFrame.getX()) {
            if (this.center.getX() < 0) {
                this.center.setX(this.startOfFrame.getX() + (-1 * this.center.getX()) + r);
            } else {
                this.center.setX(this.startOfFrame.getX() + r);
            }
        }
        // if the ball is out of frame to up
        if (this.center.getY() - this.r < this.startOfFrame.getY()) {
            if (this.center.getY() < 0) {
                this.center.setY(this.startOfFrame.getY() + (-1 * this.center.getY()) + r);
            } else {
                this.center.setY(this.startOfFrame.getY() + r);
            }
        }
        // if the ball out of frame to right
        if (this.center.getX() + this.r > this.endOfFrame.getX()) {
            this.center.setX(this.endOfFrame.getX() - this.r);
        }
        // if the ball out of frame to down
        if (this.center.getY() + this.r > this.endOfFrame.getY()) {
            this.center.setY(this.endOfFrame.getY() - this.r);
        }
    }

    /**
     * @param surface to draw the ball on
     * this function is drawing this ball on a given surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        int startOfScreen = 0;
        if (this.startOfFrame == null) { // checking if the variable start of frame initialized
            Point startOfFrame = new Point(startOfScreen, startOfScreen);
            this.setStartOfFrame(startOfFrame); // if not, setting it
        }
        if (this.endOfFrame == null) { // checking if the variable end of frame initialized
            int height = surface.getHeight();
            int width = surface.getWidth();
            Point endOfFrame = new Point(width, height);
            this.setEndOfFrame(endOfFrame); // if not, setting it according to the given surface
        }
        this.check(); // checks function
        int x = (int) this.center.getX();
        int y = (int) this.center.getY();
        surface.setColor(Color.BLACK);
        surface.drawCircle(x, y, this.r);
        surface.setColor(color); // setting this ball's color
        surface.fillCircle(x, y, this.r); // drawing the ball
    }
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * @param startOfFrame point
     * this function is setting the start of frame point of this ball to a given start of frame point
     */
    public void setStartOfFrame(Point startOfFrame) {
        this.startOfFrame = startOfFrame;
    }
    /**
     * @param endOfFrame point
     * this function is setting the end of frame point of this ball to a given end of frame point
     */
    public void setEndOfFrame(Point endOfFrame) {
        this.endOfFrame = endOfFrame;
    }
    /**
     * @param v velocity variable
     * this function is setting the velocity of this ball to a given velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * @param dx movement on x
     * @param dy movement on y
     * this function is setting the velocity of this ball to a new velocity
     * according to a given dx (movement on x) and dy (movement on y)
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * @return this ball's velocity
     * this function is returning this ball's velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * @param g - given GameLevel
     * this function is adding this ball to the given game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this function if the ball is stuck in one of the game's collidables,
     * and if so, the function changing tha ball center so it will be out.
     */
    public void isStuck() {
        List<Collidable> gameColls = ge.getGamesColls(); // list of the game collidables
        int index = 0;
        for (Collidable coll : gameColls) {
            Rectangle rec = coll.getCollisionRectangle();
            Point upperLeft = rec.getUpperLeft();
            Point downerRight = rec.getDownerRight();
            if ((this.center.getX() > upperLeft.getX()) && (this.center.getX() < downerRight.getX())) {
                if ((this.center.getY() > upperLeft.getY()) && (this.center.getY() < downerRight.getY())) {
                    if (index == 0) { // up border
                        this.center.setY(rec.getDownerLeft().getY() + 1);
                    } else if (index == 1) { // left border
                        this.center.setX(rec.getDownerRight().getX() + 1);
                    } else if (index == 2) { // down border
                        this.center.setY(rec.getUpperLeft().getY() - 1);
                    } else if (index == 3) { // right border
                        this.center.setX(rec.getDownerLeft().getX() - 1);
                    } else if (index == gameColls.size() - 1) { // paddle
                        if (this.center.distance(upperLeft) > this.center.distance(downerRight)) {
                            this.center.setX(downerRight.getX());
                        } else {
                            this.center.setX(upperLeft.getX());
                        }
                    }
                }
            }
            index++;
        }
    }
    /**
     * this function is moving the ball one step, according to this velocity.
     */
    public void moveOneStep() {
            this.isStuck(); // check if the ball stuck
            Line trajectory = new Line(center, this.getVelocity().applyToPoint(this.center)); // path of the ball
            CollisionInfo ci = ge.getClosestCollision(trajectory);
            if (ci == null) { // there is no collision
                this.center = this.getVelocity().applyToPoint(this.center);
            } else { // there is collision
                if (this.velocity.getDx() < 0) {
                    this.center.setX(ci.collisionPoint().getX() + 1);
                } else {
                    this.center.setX(ci.collisionPoint().getX() - 1);
                }
                if (this.velocity.getDy() < 0) {
                    this.center.setY(ci.collisionPoint().getY() + 1);
                } else {
                    this.center.setY(ci.collisionPoint().getY() - 1);
                }
                this.velocity = ci.collisionObject().hit(this, ci.collisionPoint(), this.velocity); // updating velocity
            }
    }

    /**
     * @param g - given game
     * This function removes this ball from the given game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}