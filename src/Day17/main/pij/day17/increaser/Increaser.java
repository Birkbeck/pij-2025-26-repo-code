package pij.day17.increaser;

public class Increaser implements Runnable {
    private Counter counter;

    public Increaser(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        final int NUMBER_OF_INCREASES = 1000;
        System.out.println("Starting at " + this.counter.getCount());
        for (int i = 0; i < NUMBER_OF_INCREASES; i++) {
            this.counter.increase();
        }
        System.out.println("Stopping at " + this.counter.getCount());
    }
    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 100;
        Counter counter = new Counter();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Increaser increaserTask = new Increaser(counter);
            Thread t = new Thread(increaserTask);
            t.start();
        }
    }
}
