package pij.day20.pizza.server;

/**
 * Thread-safe counter class.
 */
public class Counter {

    private int count; // initialised to 0 by the empty no-args constructor

    public synchronized void incrementCount() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

}
