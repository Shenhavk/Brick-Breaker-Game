package Interfaces;
import ShownObjects.Ball;
import ShownObjects.Block;

/**
 * Shenhav Katzav id: 209190560.
 * interface HitListener
 * interface for hit listener.
 */

public interface HitListener {
    /**
     * @param beingHit - the object that being hit
     * @param hitter - the Ball that's doing the hitting
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}