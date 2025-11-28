package pij.day17.countSynchronisedByMethod;

/**
 * Artificial example of an originally very much non-thread-safe implementation
 * of a method that would always return 0 if its execution were atomic.
 *
 * Repaired by making method getCount() synchronized.
 */
public class ZeroCount {
    private int count = 0;

    private void increment() {
        this.count++;
    }
    private void decrement() {
        this.count--;
    }

    /**
     * Returns the current value of the internal counter after first
     * incrementing it and then decrementing it in a non-atomic way.
     * <p>
     * Add "synchronized" after "public" to ensure that always 0 is returned
     * also if different threads have access to the method.
     *
     * @return the current value of the internal counter
     */
    public synchronized int getCount() {
        increment();
        decrement();
        return this.count;
    }
}
