package pij.day19solutions.fibonacciMultiThread;

import javax.swing.JLabel;
import javax.swing.SwingWorker;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * Day 19, Exercise 4.5.
 * Worker class whose objects are to be executed in a separate thread that
 * does the actual work for our Fibonacci GUI. This lets the GUI stay reactive
 * while the computation of a result of the Fibonacci function is ongoing.
 * See also the documentation of class SwingWorker.
 */
public class FibonacciWorker extends SwingWorker<String, Object> {

    /**
     * The input for which we want to compute the value of the Fibonacci
     * function.
     */
    private final int input;

    /**
     * The algorithm chosen for the computation of the Fibonacci function.
     * Non-null.
     */
    private final FibAlg algorithm;

    /** The result of the computation will be placed here. Non-null. */
    private final JLabel outputLabel;

    /**
     * Constructs a new FibonacciWorker for the given parameters.
     *
     * @param input we want to compute the Fibonacci function for this input
     * @param algorithm the algorithm to use for the computation
     * @param outputLabel will be updated with the result of the computation
     * @throws NullPointerException if algorithm or outputLabel are null
     */
    public FibonacciWorker(int input, FibAlg algorithm, JLabel outputLabel) {
        this.input = input;
        this.algorithm = Objects.requireNonNull(algorithm);
        this.outputLabel = Objects.requireNonNull(outputLabel);
    }

    @Override
    protected String doInBackground() {
        long nanos1 = System.nanoTime();
        long result = this.algorithm.getAlgorithm().apply(this.input);
        long nanos2 = System.nanoTime();
        String message = this.algorithm + " has run; input " + this.input
                + ", result " + result + ", duration: "
                + ((nanos2 - nanos1) / 1000000) + " ms.";
        return message;
    }

    /**
     * Sets the text of the output label when the computation is done.
     */
    @Override
    protected void done() {
        try {
            this.outputLabel.setText(this.get());
        } catch (InterruptedException | ExecutionException e) {
            // the syntax in the previous line with the "|" lets us catch both
            // InterruptedException and ExecutionException in the same way
            // (another DRY feature in the Java language)
            throw new RuntimeException(e);
        }
    }
}
