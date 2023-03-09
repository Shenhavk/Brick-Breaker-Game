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
 * class Wide Easy
 * class for the second level, "Wide Easy", implements LevelInformation interface
 */

public class WideEasy implements LevelInformation {
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
    public WideEasy() {
        this.numberOfBalls = 10;
        this.initialBallVelocities = new ArrayList<>();
        this.paddleSpeed = 6;
        this.paddleWidth = 600;
        this.levelName = "Wide Easy";
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(111, 166, 220));
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 15;
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
        int angle = 72;
        for (int i = 0; i < numberOfBalls; i++) {
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(angle, 5));
            angle -= 16;
        }
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
        int blockWidth = 49;
        int blockHeight = 25;
        int startX = 26;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.RED));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.RED));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.ORANGE));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.ORANGE));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.YELLOW));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.YELLOW));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.GREEN));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.GREEN));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.GREEN));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.BLUE));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.BLUE));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.PINK));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.PINK));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.CYAN));
        startX += blockWidth + 1;
        this.blocks.add(new Block(new Rectangle(new Point(startX, 250), blockWidth, blockHeight), Color.CYAN));
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