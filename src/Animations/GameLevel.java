package Animations;
import Collids.GameEnvironment;
import Collids.SpriteCollection;
import Default.AnimationRunner;
import Default.Counter;
import Default.ScoreIndicator;
import Default.Velocity;
import Interfaces.Animation;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Listeners.BallAdder;
import Listeners.BallRemover;
import Listeners.BlockRemover;
import Listeners.ScoreTrackingListener;
import Shapes.Point;
import Shapes.Rectangle;
import ShownObjects.Ball;
import ShownObjects.Block;
import ShownObjects.Paddle;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class GameLevel
 * class for Game Level, implements Animation interface.
 */

public class GameLevel implements Animation {
    private final GameEnvironment environment;
    private final LevelInformation levelInfo;
    private final SpriteCollection sprites;
    private final AnimationRunner runner;
    private final KeyboardSensor ks;
    private final ScoreIndicator si;
    private final Counter numBlocks;
    private final Counter numBalls;
    private final Counter score;
    private final Paddle paddle;
    private final int height;
    private boolean running;
    private final int width;
    private final GUI gui;

    /**
     * @param levelInfo - given level information
     * @param gui - given gui
     * @param ks - given keyboard sensor
     * @param ar - given Animation runner
     * @param width - given width of screen
     * @param height - given height of screen
     * @param score - given score counter
     * constructor.
     */
    public GameLevel(LevelInformation levelInfo, GUI gui, KeyboardSensor ks, AnimationRunner ar,
                     int width, int height, Counter score) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.numBlocks = new Counter();
        this.numBalls = new Counter();
        this.levelInfo = levelInfo;
        this.height = height;
        this.width = width;
        this.score = score;
        this.runner = ar;
        this.gui = gui;
        this.ks = ks;
        this.running = false;
        this.si = new ScoreIndicator(this.score);
        this.paddle = new Paddle(gui.getKeyboardSensor(), this.levelInfo.paddleSpeed(), this.levelInfo.paddleWidth(),
                20, Color.ORANGE.darker());
    }

    /**
     * @return - currently number of balls in game
     * this function returns the number of balls that are in game
     */
    public int getNumBalls() {
        return this.numBalls.getValue();
    }

    /**
     * @return - currently number of blocks in game
     * this function returns the number of blocks that are in game
     */
    public int getNumBlocks() {
        return this.numBlocks.getValue();
    }

    /**
     * @return - this gui
     * this function is returning this gui
     */
    public biuoop.GUI getGui() {
        return this.gui;
    }

    /**
     * @param c - given collidable
     * this function adds the given collidable to the game environment
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s - given sprite
     * this function adds the given sprite to the game environment
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this function initializes a new game: creates the blocks, ball and Paddle,
     * and adds them to the game.
     */
    public void initialize() {
        Block[] borders = generateBorders();
        for (Block border : borders) {
            border.addToGame(this);
        }
        generateBlocks();
        generateBalls();
        this.si.addToGame(this);
        paddle.addToGame(this);
    }

    /**
     * @return array of the screen's borders
     * this function generates the screen's borders and returning array of them
     */
    public Block[] generateBorders() {
        int borderSize = 25;
        BallRemover br = new BallRemover(this, numBalls);
        Block[] borders = new Block[4];
        borders[0] = (new Block(new Rectangle(new Point(0, 0), width, borderSize), Color.GRAY));
        borders[1] = (new Block(new Rectangle(new Point(0, 0), borderSize, height), Color.GRAY));
        borders[2] = (new Block(new Rectangle(new Point(borderSize,
                height - (borderSize - 15)), width, borderSize), Color.DARK_GRAY));
        borders[2].addHitListener(br);
        borders[3] = (new Block(new Rectangle(new Point(width - borderSize, 0), borderSize, height), Color.GRAY));
        return borders;
    }

    /**
     * this function generates the game's blocks and adds them to the game.
     */
    public void generateBlocks() {
        List<Block> blocks = this.levelInfo.blocks();
        BallAdder ba = new BallAdder(this, this.numBalls);
        BlockRemover br = new BlockRemover(this, numBlocks);
        ScoreTrackingListener stl = new ScoreTrackingListener(score);
        for (Block block : blocks) {
            this.numBlocks.increase(1);
            block.addHitListener(br);
            block.addHitListener(stl);
            if ((this.levelInfo.levelName().equals("Green3")
                    || this.levelInfo.levelName().equals("Final Four")) // Bonus balls
                    && block.getColor() == Color.YELLOW) {
                block.addHitListener(ba);
            }
            block.addToGame(this);
        }
    }

    /**
     * this function generates the game's balls and adds them to the game.
     */
    public void generateBalls() {
        Ball[] balls = new Ball[this.levelInfo.numberOfBalls()];
        List<Velocity> initialBallVelocities = this.levelInfo.initialBallVelocities();
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(new Point(400, 500), 4, Color.WHITE);
            this.numBalls.increase(1);
            balls[i].setVelocity(initialBallVelocities.get(i));
            balls[i].setGameEnvironment(this.environment);
            balls[i].addToGame(this);
        }
    }

    /**
     * @param start - given point
     * this function adds new ball to the game, so that the new ball's
     * start point will be the given point
     */
    public void addNewBall(Point start) {
        Ball ball = new Ball(start, 4, Color.RED);
        ball.setVelocity(Velocity.fromAngleAndSpeed(50, 4));
        ball.setGameEnvironment(this.environment);
        ball.addToGame(this);
    }

    /**
     * this function runs the game, starting the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites, levelInfo)); // countdown before turn starts.
        this.runner.setCountDownScreen();
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
        this.runner.setCountDownScreen();
    }

    /**
     * @param c - given collidable
     * this function removes the given collidable from the environment
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * @param s - given sprite
     * this function removes the given sprite from the game's sprites list
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * @param d - given Drawsurface
     * this function is drawing the level's name on the given surface
     */
    public void drawLevelName(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(30, 18, "Level Name: " + this.levelInfo.levelName(), 15);
    }

    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        this.drawBackground(d);
        this.sprites.drawAllOn(d);
        this.drawLevelName(d);
        this.sprites.notifyAllTimePassed();

        if (this.gui.getKeyboardSensor().isPressed("p")) {
            Animation pause = new PauseScreen(ks);
            this.runner.run(new KeyPressStoppableAnimation(ks, ks.SPACE_KEY, pause));
        }

        if (this.numBlocks.getValue() == 0) {
            this.running = false;
            this.score.increase(100);
            this.drawBackground(d);
            this.sprites.drawAllOn(d);
            this.drawLevelName(d);
            this.sprites.notifyAllTimePassed();
        }

        if (this.numBalls.getValue() == 0) {
            this.running = false;
            this.drawBackground(d);
            this.sprites.drawAllOn(d);
            this.drawLevelName(d);
            this.sprites.notifyAllTimePassed();
        }
    }

    /**
     * @return - true if the animation should stop, otherwise false
     * this function is in charge of checking if the animation should stop
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @param d - given surface
     * this function draws the background on the given surface, for each level.
     */
    public void drawBackground(DrawSurface d) {
        this.levelInfo.getBackground().drawOn(d);
        switch (this.levelInfo.levelName()) {
            case "Direct Hit":
                d.setColor(Color.BLUE);
                d.drawCircle(400, 170, 85);
                d.drawCircle(400, 170, 115);
                d.drawCircle(400, 170, 145);
                d.drawLine(400, 25, 400, 150);
                d.drawLine(400, 190, 400, 340);
                d.drawLine(225, 170, 375, 170);
                d.drawLine(425, 170, 575, 170);
                break;
            case "Wide Easy":
                d.setColor(new Color(255, 255, 150));
                int endX = 26;
                int endY = 249;
                for (int i = 0; i < 50; i++) {
                    d.drawLine(150, 150, endX, endY);
                    endX += 15;
                }
                d.fillCircle(150, 150, 60);
                d.setColor(new Color(255, 255, 120));
                d.fillCircle(150, 150, 54);
                d.setColor(new Color(255, 255, 75));
                d.fillCircle(150, 150, 48);
                break;
            case "Green3":
                int startX = 56, width = 9;
                int y = 482, height = 20;
                d.setColor(new Color(98, 108, 98));
                d.fillRectangle(96, 250, 8, 175);
                d.setColor(new Color(51, 56, 51));
                d.fillRectangle(88, 425, 24, 50);
                d.setColor(new Color(40, 44, 40));
                d.fillRectangle(50, 475, 100, 115);
                d.setColor(new Color(151, 164, 151));
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 7; i++) {
                        d.fillRectangle(startX, y, width, height);
                        startX += 13;
                    }
                    startX = 56;
                    y += 28;
                }
                d.setColor(new Color(234, 184, 96));
                d.fillCircle(100, 250, 12);
                d.setColor(new Color(234, 96, 96));
                d.fillCircle(100, 250, 8);
                d.setColor(Color.WHITE);
                d.fillCircle(100, 250, 3);
                break;
            case "Final Four":
                int x = 143;
                y = 425;
                d.setColor(new Color(172, 178, 172));
                for (int i = 0; i < 10; i++) {
                    d.drawLine(x, y, (x - 25), 590);
                    x += 8;
                }
                x = 605;
                y = 485;
                for (int i = 0; i < 10; i++) {
                    d.drawLine(x, y, (x - 35), 590);
                    x += 8;
                }
                d.setColor(new Color(145, 150, 145));
                d.fillCircle(145, 425, 20);
                d.fillCircle(600, 470, 20);
                d.fillCircle(155, 433, 25);
                d.fillCircle(618, 497, 25);
                d.setColor(new Color(123, 133, 123));
                d.fillCircle(173, 413, 25);
                d.fillCircle(635, 479, 25);
                d.setColor(new Color(107, 114, 107));
                d.fillCircle(200, 425, 28);
                d.fillCircle(660, 482, 28);
                d.setColor(new Color(107, 114, 107));
                d.fillCircle(185, 440, 21);
                d.fillCircle(648, 495, 21);
                break;
            default:
                break;
        }
    }
}