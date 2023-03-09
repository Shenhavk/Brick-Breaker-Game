package Animations;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Shenhav Katzav id: 209190560.
 * class PauseScreen.
 * class for Pause Screen, implements Animation interface.
 */

public class PauseScreen implements Animation {
    private final KeyboardSensor keyboard;
    private final boolean stop;

    /**
     * @param k - given keyboard sensor.
     * constructor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.CYAN.darker().darker());
        d.fillRectangle(330, 90, 40, 140);
        d.fillRectangle(390, 90, 40, 140);
        d.drawText(160, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    /**
     * @return - true if the animation should stop, otherwise false
     * this function is in charge of checking if the animation should stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}