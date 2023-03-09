package Listeners;
import Default.Counter;
import Interfaces.HitListener;
import ShownObjects.Ball;
import ShownObjects.Block;

/**
 * Shenhav Katzav id: 209190560.
 * class ScoreTrackingListener.
 * Implements hit listener interface.
 * class for Score tracking listener. The member is counter of the score.
 * this class is in charge of increasing the score anytime a ball hitting a block.
 */

public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * @param scoreCounter - given score counter
     * constructor.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit - the object that being hit
     * @param hitter - the Ball that's doing the hitting
     * This method is called whenever the beingHit object is hit.
     * in this case, this method increasing the score whenever a block got hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
        beingHit.removeHitListener(this);
    }
}