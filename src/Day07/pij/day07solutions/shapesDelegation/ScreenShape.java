package pij.day07solutions.shapesDelegation;

import pij.day06.point.Point;
import pij.day07.shape.Shape;

/**
 * A ScreenShape represents a geometric shape at a given position on the
 * screen.
 */
public class ScreenShape implements Shape {
    private final Point topLeft;
    private final Shape shape;

    /**
     * Constructs a new ScreenShape with a given top-left position and a given
     * Shape.
     *
     * @param topLeft the top-left position for this ScreenShape
     * @param shape the actual Shape
     */
    public ScreenShape(Point topLeft, Shape shape) {
        // make a copy of topLeft to ensure that the caller to the constructor
        // cannot accidentally or intentionally modify this ScreenShape by
        // calling mutators on the object that was passed as parameter
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.shape = shape;
    }

    @Override
    public double area() {
        return shape.area(); // delegation
    }

    @Override
    public double perimeter() {
        return shape.perimeter(); // delegation
    }

    /**
     * Moves the top-left position of this ScreenShape to the position of the
     * given parameter.
     *
     * @param newTopLeft the position that the top left of this ScreenShape
     *                   will have
     */
    public void moveTopLeft(Point newTopLeft) {
        topLeft.moveTo(newTopLeft);
    }
}
