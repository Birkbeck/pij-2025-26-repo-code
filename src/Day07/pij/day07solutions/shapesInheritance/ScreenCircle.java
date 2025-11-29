package pij.day07solutions.shapesInheritance;

import pij.day06.point.Point;

/**
 * A ScreenCircle is a ScreenShape corresponding to a circle (Ex 8).
 */
public class ScreenCircle extends ScreenShape {
    private final int radius;

    /**
     * Initialises a new ScreenCircle according to the constructor
     * parameters.
     *
     * @param topLeft the top left point of the screen circle; may be
     *                modified after the constructor call without affecting
     *                this ScreenCircle
     * @param radius the radius of the circle
     */
    public ScreenCircle(Point topLeft, int radius) {
        super(topLeft);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
