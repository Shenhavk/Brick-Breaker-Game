package Default;

import Animations.EndScreen;
import Animations.GameLevel;
import Animations.KeyPressStoppableAnimation;
import Interfaces.Animation;
import Interfaces.LevelInformation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class GameFlow
 * class for the game flow. runs the levels one after another.
 */

public class GameFlow {
    private final AnimationRunner ar;
    private final KeyboardSensor ks;
    private final GUI gui;
    private final int width;
    private final int height;
    private final Counter score;
    private final Sleeper sleeper;
    private final DrawSurface d;

    /**
     * @param ar - given animation runner
     * @param ks - given keyboard sensor
     * @param gui - given gui
     * @param width - given width of screen
     * @param height - given height of screen
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, int width, int height) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.width = width;
        this.height = height;
        this.score = new Counter();
        this.sleeper = new Sleeper();
        this.d = gui.getDrawSurface();
    }

    /**
     * @param levels - given list of levels to run
     * this function runs the game according to the given levels list
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.gui, this.ks, this.ar, this.width, this.height, this.score);
            level.initialize();

            while (level.getNumBalls() != 0 && level.getNumBlocks() != 0) {
                level.run();
                this.sleeper.sleepFor(1000);
            }

            // lose case
            if (level.getNumBalls() == 0) {
                sleeper.sleepFor(1000);
                Animation endScreen = new EndScreen(ks, false, score);
                ar.setCountDownScreen();
                ar.run(new KeyPressStoppableAnimation(ks, ks.SPACE_KEY, endScreen));
                this.gui.close();
            }
        }
        // win case
        Animation endScreen = new EndScreen(ks, true, score);
        ar.setCountDownScreen();
        ar.run(new KeyPressStoppableAnimation(ks, ks.SPACE_KEY, endScreen));
        gui.close();
    }
}