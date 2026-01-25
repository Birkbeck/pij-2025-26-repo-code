package pij.day17solutions.mystery;

// Exercise 1.
// This program prints 20 "A"s and 20 "B"s, mixed in arbitrary order.
// (Run the program several times!) The reason is that we have one
// thread that prints an "A" at a time and one thread that prints
// a "B" at a time running concurrently. It depends on the scheduler
// used by the JVM which thread can make progress.
public class WarmUpMystery {

    private static void helper(boolean aFlag) {
        final int MAX = 20;
        for (int i = 0; i < MAX; i++) {
            System.out.print(aFlag ? "A" : "B");
        }
    }

    public static void main(String[] args) {
        Runnable rA = () -> helper(true);
        Runnable rB = () -> helper(false);
        new Thread(rA).start();
        new Thread(rB).start();
    }
}
