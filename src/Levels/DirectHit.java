package Levels;

import Default.Velocity;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Point;
import Shapes.Rectangle;
import ShownObjects.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class Direct Hit
 * class for the first level, "Direct Hit", implements LevelInformation interface
 */

public class DirectHit implements LevelInformation {
    private final int numberOfBalls;
    private final List<Velocity> initialBallVelocities;
    private final int paddleSpeed;
    private final int paddleWidth;
    private final String levelName;
    private final Sprite background;
    private final List<Block> blocks;
    private final int numberOfBlocksToRemove;

    /**
     * constructor.
     */
    public DirectHit() {
        this.numberOfBalls = 1;
        this.initialBallVelocities = new ArrayList<>();
        this.paddleSpeed = 6;
        this.paddleWidth = 80;
        this.levelName = "Direct Hit";
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLACK);
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 1;
    }
    /**
     * @return - number of balls
     * this function returns the number of balls in the level
     */
    public int numberOfBalls() {
        return this.numberOfBalls;
    }
    /**
     * @return - list of velocities
     * this function returns list of the velocities of the balls
     */
    public List<Velocity> initialBallVelocities() {
        this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(0, -5));
        return this.initialBallVelocities;
    }

    /**
     * @return - the paddle's speed
     * this function returns the paddle's speed
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }
    /**
     * @return - the paddle's width
     * this function returns the paddle's width
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * @return - the level's name
     * this function returns the level's name
     */
    public String levelName() {
        return this.levelName;
    }

    /**
     * @return - the level's background
     * this function returns the level's background
     */
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * @return - list of the level's blocks
     * this function returns list of the Blocks that make up this level,
     * each block contains its size, color and location.
     */
    public List<Block> blocks() {
        this.blocks.add(new Block(new Rectangle(new Point(380, 150), 40, 40), Color.RED));
        return blocks;
    }

    /**
     * @return - number of the level's blocks
     * this function returns the number of blocks that should be removed,
     * before the level is considered to be "cleared".
     */
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}