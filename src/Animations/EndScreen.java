package Animations;

import Default.Counter;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Shenhav Katzav id: 209190560.
 * class EndScreen.
 * class for End Screen, implements Animation interface.
 */

public class EndScreen implements Animation {
    private final KeyboardSensor keyboard;
    private final boolean stop;
    private final boolean isWin;
    private final Counter score;

    /**
     * @param k - given keyboard sensor
     * @param isWin - given flag in order to know whether user win or lose
     * @param score - given score
     * constructor.
     */
    public EndScreen(KeyboardSensor k, boolean isWin, Counter score) {
        this.keyboard = k;
        this.isWin = isWin;
        this.score = score;
        this.stop = false;
    }
    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        if (isWin) {
            d.setColor(Color.WHITE);
            d.fillRectangle(0,0, 800, 600);
            d.setColor(Color.GREEN.darker().darker());
            d.drawCircle(360, 160, 90);
            d.drawCircle(325, 120, 20);
            d.drawCircle(395, 120, 20);
            d.drawCircle(360, 200, 35);
            d.setColor(Color.WHITE);
            d.fillRectangle(325, 165, 70, 35);
            d.setColor(Color.GREEN.darker().darker());
            d.drawRectangle(350, 150, 20, 40);
            d.drawLine(325, 200, 395 ,200);
            d.drawLine(335, 200, 335 ,223);
            d.drawLine(345, 200, 345 ,230);
            d.drawLine(355, 200, 355 ,235);
            d.drawLine(365, 200, 365 ,235);
            d.drawLine(375, 200, 375 ,230);
            d.drawLine(385, 200, 385 ,223);
            d.drawText(160, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);
        } else {
            d.setColor(Color.RED.darker().darker());
            d.drawCircle(360, 160, 90);
            d.drawCircle(325, 120, 20);
            d.drawCircle(395, 120, 20);
            d.drawRectangle(350, 150, 20, 40);
            d.drawRectangle(310, 210, 100, 15);
            d.drawLine(310, 210, 325 ,225);
            d.drawLine(325, 225, 340 ,210);
            d.drawLine(340, 210, 355 ,225);
            d.drawLine(355, 225, 370 ,210);
            d.drawLine(370, 210, 385 ,225);
            d.drawLine(385, 225, 400 ,210);
            d.drawLine(400, 210, 410 ,225);
            d.drawText(160, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 32);
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