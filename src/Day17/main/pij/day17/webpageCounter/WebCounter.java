package pij.day17.webpageCounter;

/**
 * Class representing a web counter to track the number of views. This class
 * provides a static method to increment the view count. This class
 * demonstrates the issue of shared mutable state in a multithreaded
 * environment, as multiple threads may attempt to increment the view count
 * simultaneously.
 */
public class WebCounter {

    private int views = 0;

    public int getViews() {
        return views;
    }

    /**
     * Method to increment the view count.
     * Note: This method is not thread-safe and may lead to race conditions when accessed by multiple threads concurrently.
     */
    public void incrementViews(){
        views ++;
    };

    /**
     * Synchronized method to safely increment the view count in a multithreaded environment.
     * This method ensures that only one thread can execute it at a
     */
    public synchronized void synchronizedIncrementViews(){
        views ++;
    }

        /**
     * Method to safely increment the view count using an explicit lock.
     * This method uses a synchronized block to ensure that only one thread can access the critical section
     */
    public static void synchronizedUsingLockIncreasingViews(){
        synchronized (lock){
            views ++;
        }
    }
}
