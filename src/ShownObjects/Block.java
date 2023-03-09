package ShownObjects;
import Animations.GameLevel;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.Sprite;
import Interfaces.HitNotifier;
import Default.Velocity;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class Block
 * implements collidable and sprite interfaces
 * class for Block. members are collision rectangle (location), and color.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisionRectangle;
    private final java.awt.Color color;
    private final List<HitListener> hitListeners;

    /**
     * @param collisionRectangle - given rectangle (location) of the block
     * @param color - given color
     * constructor
     */
    public Block(Rectangle collisionRectangle, java.awt.Color color) {
        this.collisionRectangle = collisionRectangle;
        this.color = color;
        hitListeners = new ArrayList<>();
    }

    /**
     * @param collisionRectangle - given rectangle
     * this function is updating the collision rectangle (location)
     * of the block to a given rectangle
     */
    public void setCollisionRectangle(Rectangle collisionRectangle) {
        this.collisionRectangle = collisionRectangle;
    }

    /**
     * @return - collision rectangle (location) of the block
     * this function is returning the collision rectangle (location) of the block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
    }

    /**
     * @param hitter - given ball that made the hit
     * @param collisionPoint - the point where the ball hit the block
     * @param currentVelocity - of the ball, to update
     * @return updated velocity of the ball
     * this function is checking where the ball hit and returning the updated velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newV = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        Line leftLine = new Line(this.collisionRectangle.getUpperLeft(), this.collisionRectangle.getDownerLeft());
        Line rightLine = new Line(this.collisionRectangle.getUpperRight(), this.collisionRectangle.getDownerRight());
        Line upLine = new Line(this.collisionRectangle.getUpperLeft(), this.collisionRectangle.getUpperRight());
        Line downLine = new Line(this.collisionRectangle.getDownerLeft(), this.collisionRectangle.getDownerRight());
        this.notifyHit(hitter);
        if (rightLine.isOnLine(collisionPoint)) { // the ball hit the right line of the block
            if (newV.getDx() < 0) {
                newV.setDx(-1 * newV.getDx());
            }
            if (upLine.isOnLine(collisionPoint) || downLine.isOnLine(collisionPoint)) { // corner case
                newV.setDy(-1 * newV.getDy());
            }
            return newV;
        }
        if (leftLine.isOnLine(collisionPoint)) { // the ball hit the left line of the block
            if (newV.getDx() > 0) {
                newV.setDx(-1 * newV.getDx());
            }
            if (upLine.isOnLine(collisionPoint) || downLine.isOnLine(collisionPoint)) { // corner case
                newV.setDy(-1 * newV.getDy());
            }
            return newV;
        }
        if (downLine.isOnLine(collisionPoint)) { // the ball hit the down line of the block
            if (newV.getDy() < 0) {
                newV.setDy(-1 * newV.getDy());
            }
            if (rightLine.isOnLine(collisionPoint) || leftLine.isOnLine(collisionPoint)) { // corner case
                newV.setDx(-1 * newV.getDx());
            }
            return newV;
        }
        if (upLine.isOnLine(collisionPoint)) { // the ball hit the upper line of the block
            if (newV.getDy() > 0) {
                newV.setDy(-1 * newV.getDy());
            }
            if (rightLine.isOnLine(collisionPoint) || leftLine.isOnLine(collisionPoint)) { // corner case
                newV.setDx(-1 * newV.getDx());
            }
            return newV;
        }
        return newV;
    }

    /**
     * @param surface - given surface to draw the block on
     * this function is drawing the block on the given surface.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color); // setting this block's color
        surface.fillRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.getCollisionRectangle().getHeight()); // drawing the ball
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.getCollisionRectangle().getHeight()); // drawing the ball
    }
    /**
     * currently nothing, use for animated blocks in the future.
     */
    public void timePassed() {

    }

    /**
     * @param g - given game
     * this function is adding this block to a given game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * @param gameLevel - given gameLevel
     * this function removes this block from the given gameLevel.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
    /**
     * @param hl - given hit listener
     * this function adds hl as a listener to hit events.
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    /**
     * @param hl - given hit listener
     * this function removes hl from the list of listeners to hit events.
     */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * @param hitter - given ball
     * this function notifies to all listeners about a hit event.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * @return - block's color
     * this function returns the block's color
     */
    public Color getColor() {
        return this.color;
    }
}