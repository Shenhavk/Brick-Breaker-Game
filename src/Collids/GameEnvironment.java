package Collids;
import Interfaces.Collidable;
import Shapes.Line;
import Shapes.Point;
import java.util.ArrayList;

/**
 * Shenhav Katzav id: 209190560.
 * class GameEnvironment
 * class for the game environment. member is the game's collidables
 */

public class GameEnvironment {
    private final java.util.List<Collidable> gamesColls;
    /**
     * constructor.
     */
    public GameEnvironment() {
        this.gamesColls = new ArrayList<>();
    }

    /**
     * @param c - given collidable
     * this function adds the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        gamesColls.add(c);
    }

    /**
     * @return - the collidables list
     * this function is returning the collidables list
     */
    public java.util.List<Collidable> getGamesColls() {
        return this.gamesColls;
    }

    /**
     * @param trajectory - the path of the object
     * @return information about the closest collision to the object that is going to occur
     * this function assuming an object moving from start of line to end of line.
     * if this object will collide with any of the collidables during his path, return the information
     * of the closest collision that is going to occur. otherwise, return null
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.gamesColls.isEmpty()) { // for the case that there are no collidables
            return null;
        }
        java.util.List<Point> points = new ArrayList<>();
        java.util.List<Collidable> blocks = new ArrayList<>();
        for (Collidable block : this.gamesColls) { // get the intersection points
            Point inter = trajectory.closestIntersectionToStartOfLine(block.getCollisionRectangle());
            if (inter != null) {
                points.add(inter);
                blocks.add(block);
            }
        }
        if (points.isEmpty()) { // for the case that there are no intersection points
            return null;
        }
        Point theClosest = points.get(0);
        Collidable collObject = blocks.get(0);
        for (int i = 1; i < points.size(); i++) { // find the closest intersection
            if (trajectory.start().distance(points.get(i)) < trajectory.start().distance(theClosest)) {
                theClosest = points.get(i);
                collObject = blocks.get(i);
            }
        }
        return new CollisionInfo(theClosest, collObject);
    }
    /**
     * @param c - given collidable
     * this function removes the given collidable to the environment.
     */
    public void removeCollidable(Collidable c) {
        this.gamesColls.remove(c);
    }
}