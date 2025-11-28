package pij.day17.count;

public class ZeroCountRunnable implements Runnable {
    private final ZeroCount counter;
    private final String outputPrefix;

    public ZeroCountRunnable(ZeroCount counter, String prefix) {
        this.counter = counter;
        this.outputPrefix = prefix;
    }

    @Override
    public void run() {
        ZeroCountHelper.countMany(this.counter, this.outputPrefix);
    }
}
