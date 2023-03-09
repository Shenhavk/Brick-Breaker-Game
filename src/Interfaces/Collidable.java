package Interfaces;
import Default.Velocity;
import Shapes.Point;
import Shapes.Rectangle;
import ShownObjects.Ball;

/**
 * Shenhav Katzav id: 209190560.
 * interface Collidable
 * interface for an collidable object
 */

public interface Collidable {
    /**
     * @return - "collision shape" of the object (rectangle)
     * this function returns the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * @param hitter - the Ball that's doing the hitting
     * @param collisionPoint - the point where the collision occured
     * @param currentVelocity - velocity of the ball
     * @return the new velocity expected after the hit
     * this function notify the object that we collided with it at collisionPoint with a given velocity.
     * and returning the new velocity expected after the hit (based on the force the object inflicted on us)
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}