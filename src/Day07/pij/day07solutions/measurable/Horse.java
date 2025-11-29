package pij.day07solutions.measurable;

/**
 * A Horse has its height as a measure.
 *
 * Ex 4: this class was not required, but shows that we can implement
 * interface Measurable in otherwise quite unrelated classes.
 */
public class Horse implements Measurable {
    private double height;
    public Horse(double height) {
        this.height = height;
    }

    @Override
    public double getMeasure() {
        return height;
    }
}
