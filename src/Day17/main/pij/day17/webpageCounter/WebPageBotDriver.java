package pij.day17.webpageCounter;

import java.util.Arrays;

/**
 * WebPageBotDriver is the main class that creates and manages multiple BotViewer threads to simulate bot viewers accessing a webpage.
 * It tracks the number of active bot threads and prints the final view count once all bots have finished.
 * This class demonstrates the use of multithreading and the challenges of shared mutable state in a concurrent environment.
 */
public class WebPageBotDriver {

    public static void main(String[] args) {
        // Create the WebCounter object to be shared among all the bot threads
        WebCounter webCounter = new WebCounter();
        final int NUMBER_OF_BOTS = 10;
        Thread[] botThreads = createBotViewers(NUMBER_OF_BOTS, webCounter);

        boolean activeBots = Arrays.stream(botThreads).anyMatch(Thread::isAlive);
        // Wait for all bot threads to finish
        while (activeBots) {
            // alternative way to count live threads
            int liveCount = Arrays.stream(botThreads).mapToInt(t -> t.isAlive() ? 1 : 0).sum();

            System.out.println("Main Thread: " + liveCount + " bot threads are alive");
            System.out.println("Current view count: " + webCounter.getViews());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("main thread was interrupted while sleeping!");
            }

            // Re-evaluate whether any bot threads are still alive
            activeBots = Arrays.stream(botThreads).anyMatch(Thread::isAlive);

            // or simply break if no live threads
            //liveCount = Arrays.stream(botThreads).mapToInt(t -> t.isAlive() ? 1 : 0).sum();
            //if (liveCount <= 0) {
            //    break;
            //}
        }

        // Print the final view count
        System.out.println("Final view count: " + webCounter.getViews());
    }

    /**
     * Create and start multiple BotViewer threads. The bot threads will
     * simulate bot viewers accessing a webpage.
     *
     * @param numberOfBots the number of bot threads to create
     * @param webCounter the shared WebCounter object
     * @return an array of the created and started bot threads
     */
    public static Thread[] createBotViewers(int numberOfBots, WebCounter webCounter) {
        Thread[] bots = new Thread[numberOfBots];
        for (int i = 0; i < numberOfBots; i++) {
            bots[i] = BotViewer.createAndStartBot("BotViewer-" + (i + 1),
                    webCounter);
        }
        return bots;
    }
}
