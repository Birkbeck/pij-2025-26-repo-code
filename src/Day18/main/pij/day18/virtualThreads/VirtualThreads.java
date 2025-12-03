package pij.day18.virtualThreads;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Constructs 10000 virtual threads that each sleep for a second.
 * Commented-out alternative: 10000 platform threads.
 *
 * Shows the performance difference for threads that spend most of
 * their time waiting.
 *
 * Adapted from: https://openjdk.org/jeps/444
 */
public class VirtualThreads {

    public static void main(String[] args) {
        long nanos1 = System.nanoTime();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
        //try (ExecutorService executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits
        long nanos2 = System.nanoTime();
        System.out.println("Done after " + (nanos2-nanos1)/1_000_000 + " ms.");
    }
}
