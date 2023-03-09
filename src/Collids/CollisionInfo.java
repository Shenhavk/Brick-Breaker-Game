package Collids;
import Interfaces.Collidable;
import Shapes.Point;

/**
 * Shenhav Katzav id: 209190560.
 * class CollisionInfo
 * class for information about collision. members are collision point, and collision object
 */

public class CollisionInfo {
    private final Point collPoint;
    private Collidable collObject;

    /**
     * @param collPoint - the point where the collision occurs
     * @param collObject - the collidable object involved in the collision
     * constructor
     */
    public CollisionInfo(Point collPoint, Collidable collObject) {
        this.collPoint = collPoint;
        this.collObject = collObject;

    }

    /**
     * @return - point of collision
     * this function is returning the point where the collision occurs
     */
    public Point collisionPoint() {
        return this.collPoint;
    }

    /**
     * @return - the collidable object involved in the collision
     * this function is returning the collidable object involved in the collision
     */
    public Collidable collisionObject() {
        return this.collObject;
    }
}