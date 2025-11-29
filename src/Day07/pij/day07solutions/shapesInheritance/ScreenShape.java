package pij.day07solutions.shapesInheritance;

import pij.day06.point.Point;
import pij.day07.shape.Shape;

/**
 * A ScreenShape represents the commonalities of Shapes for screen
 * display that their bounding box has a top left point representing
 * where the shape is on the screen (Ex 8).
 */
public abstract class ScreenShape implements Shape {
    // Ex 8: class ScreenShape does not need to implement the missing
    // methods of interface Shape because it is an abstract class.

    private final Point topLeft;

    /**
     * Initialises this ScreenShape according to the coordinates of the
     * provided Point.
     *
     * @param topLeft the top left point of the screen shape; may be modified
     *                after the constructor call without affecting this
     *                ScreenShape
     */
    public ScreenShape(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    /**
     * Moves this ScreenShape to a new position on the screen
     *
     * @param newTopLeft the new position on the screen for the
     *                   top left point of the bounding box
     */
    public void moveTo(Point newTopLeft) {
        this.topLeft.moveTo(newTopLeft);
    }
}
