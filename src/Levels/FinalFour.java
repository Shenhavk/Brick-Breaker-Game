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
 * class for the second level, "Green3", implements LevelInformation interface
 */

public class FinalFour implements LevelInformation {
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
    public FinalFour() {
        this.numberOfBalls = 3;
        this.initialBallVelocities = new ArrayList<>();
        this.paddleSpeed = 11;
        this.paddleWidth = 160;
        this.levelName = "Final Four";
        this.background = new Block(new Rectangle(new Point(0, 0), 800, 600),
                new Color(38, 123, 190));
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 105;
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
        int angle = 40;
        for (int i = 0; i < numberOfBalls; i++) {
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(angle, 5));
            angle -= 40;
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
        int blockWidth = 50;
        int blockHeight = 25;
        Point uppLeft = new Point(775, 300);
        Color[] arrCol = {Color.CYAN, Color.PINK, Color.WHITE, Color.LIGHT_GRAY, Color.GREEN, Color.RED, Color.GRAY};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Point temp1 = new Point(uppLeft.getX() - (j + 1) * blockWidth, uppLeft.getY());
                Block temp;
                if ((i == 6 && j == 14) || (i == 4 && j == 2)) { // Bonus balls
                    temp = new Block(new Rectangle(temp1, blockWidth, blockHeight), Color.YELLOW);
                } else {
                    temp = new Block(new Rectangle(temp1, blockWidth, blockHeight), arrCol[i]);
                }
                blocks.add(temp);
            }
            uppLeft = new Point(775, uppLeft.getY() - blockHeight);
        }
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