package Listeners;
import Default.Counter;
import Animations.GameLevel;
import Interfaces.HitListener;
import ShownObjects.Ball;
import ShownObjects.Block;

/**
 * Shenhav Katzav id: 209190560.
 * class BlockRemover.
 * Implements hit listener interface.
 * class for Block remover. members are the gameLevel, and counter of the blocks in the gameLevel.
 * this class is in charge of removing blocks from the gameLevel, when ball hit them.
 */

public class BlockRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBlocks;

    /**
     * @param gameLevel - given gameLevel.
     * @param removedBlocks - given counter of blocks.
     * constructor.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * @return - counter of the blocks in the gameLevel
     * this function returns the counter of the blocks in the gameLevel
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
    /**
     * @param beingHit - the object that being hit
     * @param hitter - the Ball that's doing the hitting
     * This method is called whenever the beingHit object is hit,
     * and in this case, it removes the beingHit object from the gameLevel.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}