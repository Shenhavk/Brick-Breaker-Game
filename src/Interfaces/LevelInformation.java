package Interfaces;

import Default.Velocity;
import ShownObjects.Block;

import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * interface Level Information
 * interface for the whole information about level.
 */

public interface LevelInformation {
    /**
     * @return - number of balls
     * this function returns the number of balls in the level
     */
    int numberOfBalls();
    /**
     * @return - list of velocities
     * this function returns list of the velocities of the balls
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return - the paddle's speed
     * this function returns the paddle's speed
     */
    int paddleSpeed();
    /**
     * @return - the paddle's width
     * this function returns the paddle's width
     */
    int paddleWidth();

    /**
     * @return - the level's name
     * this function returns the level's name
     */
    String levelName();

    /**
     * @return - the level's background
     * this function returns the level's background
     */
    Sprite getBackground();

    /**
     * @return - list of the level's blocks
     * this function returns list of the Blocks that make up this level,
     * each block contains its size, color and location.
     */
    List<Block> blocks();

    /**
     * @return - number of the level's blocks
     * this function returns the number of blocks that should be removed,
     * before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}