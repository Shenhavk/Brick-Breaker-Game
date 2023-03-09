import Default.AnimationRunner;
import Default.GameFlow;
import Default.Velocity;
import Interfaces.LevelInformation;
import Levels.DirectHit;
import Levels.FinalFour;
import Levels.Green3;
import Levels.WideEasy;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Shenhav Katzav id: 209190560.
 * class Ass6Game
 * class for Ass6 game.
 */

public class Ass6Game {
    /**
     * @param args - given array from command line
     * this function is initializing and running the game,
     * according to list of levels from the args array.
     */
    public static void main(String[] args) {
        int width = 800, height = 600;
        GUI gui = new GUI("Arkanoid", width, height);
        AnimationRunner ar = new AnimationRunner(gui);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow arkanoid = new GameFlow(ar, ks, gui, width, height);
        List<LevelInformation> levels = new ArrayList<>();

        if (args.length == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        } else {
            for (String numOfLevel : args) {
                switch (numOfLevel) {
                    case "1":
                        levels.add(new DirectHit());
                        break;
                    case "2":
                        levels.add(new WideEasy());
                        break;
                    case "3":
                        levels.add(new Green3());
                        break;
                    case "4":
                        levels.add(new FinalFour());
                        break;
                    default:
                        break;
                }
            }
            if (levels.isEmpty()) {
                levels.add(new DirectHit());
                levels.add(new WideEasy());
                levels.add(new Green3());
                levels.add(new FinalFour());
            }
        }
        arkanoid.runLevels(levels);
    }
}