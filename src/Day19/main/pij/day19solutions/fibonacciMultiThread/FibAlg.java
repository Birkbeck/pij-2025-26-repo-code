package pij.day19solutions.fibonacciMultiThread;

import pij.day12.fibonacci.FibonacciTry1;
import pij.day13solutions.fibonacciLoop.FibLoop;
import pij.day15.fibonacci.Fibonacci;

import java.util.function.Function;

/**
 * Day 19, Exercise 4.5.
 * Symbolic representation of different algorithms to compute the Fibonacci
 * function: recursion without and with memoisation, and a loop-based approach.
 */
public enum FibAlg {
    RECURSIVE_SIMPLE,
    RECURSIVE_MEMO,
    ITERATIVE;

    /**
     * Returns the algorithm object corresponding to this FibAlg.
     *
     * @return the algorithm object corresponding to this FibAlg
     */
    public Function<Integer, Long> getAlgorithm() {
        switch (this) {
            case RECURSIVE_SIMPLE:
                FibonacciTry1 f = new FibonacciTry1();
                return f::fib;
            case RECURSIVE_MEMO:
                return Fibonacci::fib;
            case ITERATIVE:
                return FibLoop::fibIterative;
            default:
                // If later another entry is added to the enum FibAlg, this switch
                // statement needs to be able to do something. The Java compiler does
                // not detect that the switch statement already checks all the currently
                // existing cases, so it insists that either something of type
                // Function<Integer, Long> is returned, or an exception is thrown. Here
                // we choose the second option (there is no meaningful object to return
                // with the current knowledge).
                throw new IllegalStateException("Unexpected case " + this);
        }
    }
}
