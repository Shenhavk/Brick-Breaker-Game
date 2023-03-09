package ShownObjects;
import Interfaces.Collidable;
import Interfaces.Sprite;
import Animations.GameLevel;
import Default.Velocity;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * Shenhav Katzav id: 209190560.
 * class Paddle
 * implements collidable and sprite interfaces
 * class for Paddle.
 */

public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private final Block asBlock;
    private biuoop.GUI gui;
    private int paddleSpeed;
    private int paddleWidth;
    private int paddleHeight;
    private Color color;

    /**
     * @param keyboard - given keyboard sensor
     * constructor
     */
    public Paddle(biuoop.KeyboardSensor keyboard) {
        Rectangle collisionRectangle = new Rectangle(new Point(360, 570), 80, 7);
        this.asBlock = new Block(collisionRectangle, Color.BLACK);
        this.keyboard = keyboard;
    }

    /**
     * @param keyboard - given keyboard sensor
     * @param paddleSpeed - given paddle's speed
     * @param paddleWidth - given paddle's width
     * @param paddleHeight - given paddle's height
     * @param color - given color
     * constructor.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, int paddleSpeed, int paddleWidth, int paddleHeight, Color color) {
        this.keyboard = keyboard;
        this.paddleSpeed = paddleSpeed;
        this.paddleWidth = paddleWidth;
        this.paddleHeight = paddleHeight;
        this.color = color;
        Rectangle collisionRectangle = new Rectangle(new Point(400 - (double) (paddleWidth / 2),
                590 - (paddleHeight + 20)), paddleWidth, paddleHeight);
        this.asBlock = new Block(collisionRectangle, color);
    }

    /**
     * this function is moving the paddle to the left,
     * when the user press on left key on the keyboard.
     */
    public void moveLeft() {
        Point p1 = new Point(this.asBlock.getCollisionRectangle().getUpperLeft().getX(),
                this.asBlock.getCollisionRectangle().getUpperLeft().getY());
        if (p1.getX() <= 26) { // left border
            p1.setX(26);
            this.asBlock.getCollisionRectangle().setUpperLeft(p1);
            if (this.gui != null) {
                this.drawOn(gui.getDrawSurface());
            }
            return;
        }
        p1.setX(p1.getX() - this.paddleSpeed);
        Rectangle rect = new Rectangle(p1, this.asBlock.getCollisionRectangle().getWidth(),
                this.asBlock.getCollisionRectangle().getHeight());
        this.asBlock.setCollisionRectangle(rect);
        if (this.gui != null) {
            this.drawOn(gui.getDrawSurface());
        }
    }
    /**
     * this function is moving the paddle to the right,
     * when the user press on right key on the keyboard.
     */
    public void moveRight() {
        Point p1 = new Point(this.asBlock.getCollisionRectangle().getUpperLeft().getX(),
                this.asBlock.getCollisionRectangle().getUpperLeft().getY());
        if (p1.getX() >= (774 - paddleWidth)) { // right border
            p1.setX((774 - paddleWidth));
            this.asBlock.getCollisionRectangle().setUpperLeft(p1);
            if (this.gui != null) {
                this.drawOn(gui.getDrawSurface());
            }
            return;
        }
        p1.setX(p1.getX() + this.paddleSpeed);
        Rectangle rect = new Rectangle(p1, this.asBlock.getCollisionRectangle().getWidth(),
                this.asBlock.getCollisionRectangle().getHeight());
        this.asBlock.setCollisionRectangle(rect);
        if (this.gui != null) {
            this.drawOn(gui.getDrawSurface());
        }
    }

    /**
     * this function is notify that time has passed,
     * and checking if user pressed on left or right.
     */
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) { // press left key
            this.moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY)) { // press right key
            this.moveRight();
        }
    }

    /**
     * @param d - given surface
     * this function is drawing the paddle on the given surface.
     */
    public void drawOn(DrawSurface d) {
        asBlock.drawOn(d);
    }

    /**
     * @return the paddle as collision rectangle
     * this function is returning the paddle as collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.asBlock.getCollisionRectangle();
    }
    /**
     * @param hitter - given ball that made the hit
     * @param collisionPoint the point where the ball hit the paddle
     * @param currentVelocity of the ball, to update
     * @return updated velocity of the ball
     * this function is checking where the ball hit and returning the updated velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point p1 = this.asBlock.getCollisionRectangle().getUpperLeft(); // points of the paddle
        Point p2 = this.asBlock.getCollisionRectangle().getUpperRight();
        Point p3 = this.asBlock.getCollisionRectangle().getDownerLeft();
        Point p4 = this.asBlock.getCollisionRectangle().getDownerRight();
        double speed = currentVelocity.getSpeed(); // speed of the ball
        double areaSize = (double) paddleWidth / 5;
        Line firstArea = new Line(p1, new Point((p1.getX() + (areaSize - 1)), p1.getY())); // areas of the paddle
        Line secondArea = new Line(new Point((p1.getX() + areaSize), p1.getY()),
                new Point((p1.getX() + ((2 * areaSize) - 1)), p1.getY()));
        Line thirdArea = new Line(new Point((p1.getX() + (2 * areaSize)), p1.getY()),
                new Point((p1.getX() + ((3 * areaSize) - 1)), p1.getY()));
        Line fourthArea = new Line(new Point((p1.getX() + (3 * areaSize)), p1.getY()),
                new Point((p1.getX() + ((4 * areaSize) - 1)), p1.getY()));
        Line fifthArea = new Line(new Point((p1.getX() + (4 * areaSize)), p1.getY()),
                new Point((p1.getX() + (5 * areaSize)), p1.getY()));
        Line leftLine = new Line(p1, p3); // left, right and down lines of the paddle
        Line rightLine = new Line(p2, p4);
        Line downLine = new Line(p3, p4);
        if (firstArea.isOnLine(collisionPoint)) { // collision on first area
            int newAngle = 300;
            currentVelocity = Velocity.fromAngleAndSpeed(newAngle, speed);
        } else if (secondArea.isOnLine(collisionPoint)) { // collision on second area
            int newAngle = 330;
            currentVelocity = Velocity.fromAngleAndSpeed(newAngle, speed);
        } else if (thirdArea.isOnLine(collisionPoint)) { // collision on third area
            currentVelocity.setDy(-1 * currentVelocity.getDy());
        } else if (fourthArea.isOnLine(collisionPoint)) { // collision on fourth area
            int newAngle = 30;
            currentVelocity = Velocity.fromAngleAndSpeed(newAngle, speed);
        } else if (fifthArea.isOnLine(collisionPoint)) { // collision on fifth area
            int newAngle = 60;
            currentVelocity = Velocity.fromAngleAndSpeed(newAngle, speed);
        }
        if (leftLine.isOnLine(collisionPoint) || rightLine.isOnLine(collisionPoint)) { // collision on left or right
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }
        if (downLine.isOnLine(collisionPoint)) { // collision on down line
            currentVelocity.setDy(-1 * currentVelocity.getDy());
            return currentVelocity;
        }
        return currentVelocity;
    }

    /**
     * @param g - given game
     * this function is adding the paddle to the given game, and initializing the gui.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
        this.gui = g.getGui();
    }
}