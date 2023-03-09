package Listeners;
import Animations.GameLevel;
import Default.Counter;
import Interfaces.HitListener;
import ShownObjects.Ball;
import ShownObjects.Block;

/**
 * Shenhav Katzav id: 209190560.
 * class BallRemover.
 * Implements hit listener interface.
 * class for Ball remover. members are the gameLevel, and counter of the balls in the gameLevel.
 * this class is in charge of remove ball when it hits the bottom of the screen.
 */

public class BallRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBalls;

    /**
     * @param gameLevel - given gameLevel.
     * @param removedBlocks - given counter of balls.
     * constructor.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBlocks;
    }
    /**
     * @return - counter of the balls in the gameLevel
     * this function returns the counter of the balls in the gameLevel
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * @param beingHit - the object that being hit
     * @param hitter - the Ball that's doing the hitting
     * This method is called whenever the beingHit object is hit,
     * and in this case, it removes the hitter from the gameLevel.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}