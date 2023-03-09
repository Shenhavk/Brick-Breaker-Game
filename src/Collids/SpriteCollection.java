package Collids;
import java.util.ArrayList;
import Interfaces.Sprite;
import biuoop.DrawSurface;

/**
 * Shenhav Katzav id: 209190560.
 * class SpriteCollection
 * class for the sprite collection. member is the game's sprites
 */

public class SpriteCollection {
    private final java.util.List<Sprite> gamesSprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.gamesSprites = new ArrayList<>();
    }

    /**
     * @param s - given sprite
     * this function adds the given sprite to the game's sprites list
     */
    public void addSprite(Sprite s) {
        gamesSprites.add(s);
    }

    /**
     * this function calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < gamesSprites.size(); i++) {
            gamesSprites.get(i).timePassed();
        }
    }

    /**
     * @param d - given surface
     * this function calls drawOn() on the given surface, for all sprites.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : gamesSprites) {
            s.drawOn(d);
        }
    }
    /**
     * @param s - given sprite
     * this function removes the given sprite to the game's sprites list
     */
    public void removeSprite(Sprite s) {
        this.gamesSprites.remove(s);
    }
}