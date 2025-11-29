package pij.day07solutions.shapesInheritance;

import pij.day06.point.Point;

/**
 * A ScreenRectangle is a ScreenShape with a width and a height (Ex 8).
 */
public class ScreenRectangle extends ScreenShape {
    private final int width;
    private final int height;

    /**
     * Initialises a new ScreenRectangle according to the constructor
     * parameters.
     *
     * @param topLeft the top left point of the screen rectangle; may be
     *                modified after the constructor call without affecting
     *                this ScreenRectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public ScreenRectangle(Point topLeft, int width, int height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2*(width + height);
    }
}
