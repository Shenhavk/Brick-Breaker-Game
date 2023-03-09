package Interfaces;
import Animations.GameLevel;
import biuoop.DrawSurface;

/**
 * Shenhav Katzav id: 209190560.
 * interface Sprite
 * interface for sprite.
 */

public interface Sprite {
    /**
     * @param d - given surface
     * this function draws the sprite on the given surface
     */
    void drawOn(DrawSurface d);
    /**
     * this function notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * @param g - given game
     * this function adds the sprite to the given game
     */
    void addToGame(GameLevel g);
}