package pij.day07solutions.shapesDelegation;

import pij.day07.shape.Shape;

/**
 * A Circle is a Shape defined by a given radius. The radius induces
 * area and perimeter of a Circle in the usual way.
 */
public class Circle implements Shape {
    private final int radius;

    /**
     * Constructs a new Circle with a given radius.
     *
     * @param radius the radius of the Circle
     */
    public Circle(int radius) {
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
