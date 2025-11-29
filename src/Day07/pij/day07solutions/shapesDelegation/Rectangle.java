package pij.day07solutions.shapesDelegation;

import pij.day07.shape.Shape;

/**
 * A Rectangle is a Shape defined by its width and its height (Ex 9).
 */
public class Rectangle implements Shape {
    private final int width;
    private final int height;

    /**
     * Constructs a new Rectangle with given width and height.
     *
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     */
    public Rectangle(int width, int height) {
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
