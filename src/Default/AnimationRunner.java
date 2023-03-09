package Default;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * Shenhav Katzav id: 209190560.
 * class AnimationRunner
 * class for Animation Runner. members are gui, frames per second and sleeper
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;
    private final Sleeper sleeper;
    private Boolean countDownScreen;

    /**
     * @param gui - given gui
     * constructor
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.countDownScreen = true;
    }

    /**
     * @param animation - given animation
     * this function contains loop that is in charge of running the given animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            // sleeper for the countdown screen
            if (this.countDownScreen) {
                this.sleeper.sleepFor((2000 / 3));
            } else if (milliSecondLeftToSleep > 0) { // sleeper for the other animations
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * this function is in charge of changing the countDownScreen variable when the countdown screen
     * animation begins or ends.
     */
    public void setCountDownScreen() {
        this.countDownScreen = !countDownScreen;
    }
}