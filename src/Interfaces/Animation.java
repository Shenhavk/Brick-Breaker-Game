package Interfaces;

import biuoop.DrawSurface;

/**
 * Shenhav Katzav id: 209190560.
 * interface Animation
 * interface for animation object
 */

public interface Animation {
    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return - true if the animation should stop, otherwise false
     * this function is in charge of checking if the animation should stop
     */
    boolean shouldStop();
}