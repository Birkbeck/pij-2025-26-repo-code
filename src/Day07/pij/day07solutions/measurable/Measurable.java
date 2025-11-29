package pij.day07solutions.measurable;

/**
 * Interface for classes that provide a method to return the "measure"
 * of the object, in a class-specific way.
 * (Exercise 1)
 */
public interface Measurable {

    /**
     * Returns the "measure" of an object. The notion of a "measure" is
     * defined in a class-specific way.#
     *
     * @return the "measure" of an object
     */
    double getMeasure();
}
