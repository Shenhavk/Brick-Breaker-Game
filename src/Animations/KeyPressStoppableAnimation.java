package Animations;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Shenhav Katzav id: 209190560.
 * class KeyPressStoppableAnimation
 * class for Key Press Stoppable Animation, implements Animation interface.
 */

public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * @param sensor - given sensor
     * @param key - given key
     * @param animation - given animation
     * constructor.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        // stop condition
        if (this.sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * @return - true if the animation should stop, otherwise false
     * this function is in charge of checking if the animation should stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}