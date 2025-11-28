package pij.day17.countSynchronisedByObject;

/**
 * Example class to demonstrate that Java methods are not executed atomically,
 * but that control changes between different threads.
 */
public class ZeroCountDriver {
    public static void main(String[] args) {
        ZeroCount zc = new ZeroCount();
        Runnable myRunnable = new ZeroCountRunnable(zc, "New");
        Thread t = new Thread(myRunnable); // we could also use a lambda expression
        t.start();
        ZeroCountHelper.countMany(zc, "Old");
    }
}
