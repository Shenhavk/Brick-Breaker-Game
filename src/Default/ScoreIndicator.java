package Default;
import Animations.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Shenhav Katzav id: 209190560.
 * class ScoreIndicator
 * class for Score indicator. member is the score of the game's counter.
 * implements Sprite interface.
 */

public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * @param score - given score counter
     * constructor.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * @param d - given surface
     * this function draws the sprite on the given surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(360, 18, this.toString(), 15);
    }
    /**
     * this function notify the sprite that time has passed.
     */
    public void timePassed() {

    }

    /**
     * @param g - given game
     * this function adds the sprite to the given game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @return - string of the score value
     * this function returning string of the score value to print on screen
     */
    public String toString() {
        return "Score: " + this.score.getValue();
    }
}