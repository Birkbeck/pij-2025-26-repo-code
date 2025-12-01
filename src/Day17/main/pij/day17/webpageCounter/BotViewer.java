package pij.day17.webpageCounter;

import java.util.Random;

/**
 * BotViewer is a simple class that will be used to simulate bot viewers
 * accessing a webpage and incrementing the view count.
 */
public class BotViewer implements Runnable {

    private final String botName;
    private final WebCounter webCounter;

    // Private constructor to enforce the use of the static factory method
    private BotViewer(String botName, WebCounter webCounter) {
        this.botName = botName;
        this.webCounter = webCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // Increment the view count, however this is not thread-safe, and
            // may lead to race conditions causing incorrect counts
            webCounter.incrementViews();

            // Alternatively, to use synchronized method: which is thread-safe
            // but may have performance overhead
            //webCounter.synchronizedIncrementViews();

            // Alternatively, use lock mechanism: which is also thread-safe and can be more efficient than synchronized methods in some scenarios
            //WebCounter.synchronizedUsingLockIncreasingViews();

            // Simulate some delay between views
            try {
                Random r = new Random();
                Thread.sleep(10 + r.nextInt(10));
            } catch (InterruptedException e) {
                System.out.println("Bot " + botName +
                        " was interrupted in its sleep!");
            }
        }
    }

    // Static factory method to create and start a BotViewer thread
    public static Thread createAndStartBot(String name, WebCounter webCounter) {
        Thread botThread = new Thread(new BotViewer(name, webCounter), name);
        botThread.start();
        return botThread;
    }
}
