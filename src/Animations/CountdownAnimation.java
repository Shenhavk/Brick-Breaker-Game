package Animations;

import Collids.SpriteCollection;
import Interfaces.Animation;
import Interfaces.LevelInformation;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Shenhav Katzav id: 209190560.
 * class Countdown Animation
 * class for the Countdown Animation, implements Animation interface.
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private int countFrom;
    private final SpriteCollection gameScreen;
    private Boolean stop;
    private LevelInformation li;

    /**
     * @param numOfSeconds - given num of seconds
     * @param countFrom - given num to count from
     * @param gameScreen - given game screen
     * constructor
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
    }
    /**
     * @param numOfSeconds - given num of seconds
     * @param countFrom - given num to count from
     * @param gameScreen - given game screen
     * @param li - given level information
     * constructor
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, LevelInformation li) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.li = li;
    }

    /**
     * @param d - given drawsurface
     * this function is in charge of doing one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        this.drawBackground(d);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        d.drawText(30, 18, "Level Name: " + this.li.levelName(), 15);
        d.setColor(Color.CYAN.darker().darker().darker().darker());
        d.fillCircle(400, (d.getHeight() / 2) - 10, 27);
        d.setColor(Color.WHITE);
        d.drawText(390, d.getHeight() / 2, "" + this.countFrom, 32);
        // stop condition
        if (this.countFrom == 1) {
            this.stop = true;
        }
        this.countFrom--;
    }
    /**
     * @return - true if the animation should stop, otherwise false
     * this function is in charge of checking if the animation should stop
     */
    public boolean shouldStop()  {
        return this.stop;
    }

    /**
     * @param d - given surface
     * this function draws the background on the given surface, for each level.
     */
    public void drawBackground(DrawSurface d) {
        this.li.getBackground().drawOn(d);
        switch (this.li.levelName()) {
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