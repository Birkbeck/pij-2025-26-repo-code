package pij.day17.hello;

/**
 * Driver class for Java's threads with very simple functionality.
 */
public class HelloWorldWithThreads {

    public static void main(String[] args) {
        // Run this code several times -- there are different outcomes!
        final int NUMBER_OF_THREADS = 10;
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            String s = "Thread " + i + " says: Hello, World!";
            Thread t = new Thread(() -> System.out.println(s));
            t.start();
        }
        System.out.println("The original thread says hi!");
    }
}
