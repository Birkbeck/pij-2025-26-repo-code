public class SpySolution {
    private static int activeSpyCount = 0;
    private int id;
    private boolean active;

    public SpySolution(int id) {
        activeSpyCount++;
        this.id = id;
        active = true;
    }

    public static int getNumberOfActiveSpies() {
        return activeSpyCount;
    }

    public void retire() {
        System.out.println("Spy " + id + " has retired");
        activeSpyCount--;
        active = false;
        System.out.println("Currently active spies: " + activeSpyCount);
    }

    /*

    Using static variables for anything other than constants has several
    downsides:

    - At the moment, the active spy count is "global" for the Java Virtual Machine.
      We are restricted to a single variable in the whole program to keep track of
      the number of active spies. This makes the design hard to adapt to changing
      requirements. In the real world, there tend to be several agencies for which
      spies might work. Here a better solution might be to have a class SpyAgency
      whose instances keep track of their own spies in an instance variable. When a
      Spy retires, they could tell their SpyAgency about this (which can update its
      own instance variables, e.g., for the count of their active spies) rather
      than write to a static variable.

    - As we will soon see, it is good practice to write separate unit tests for our
      classes. If our objects have shared state that is maintained over the whole
      lifetime of the JVM, it becomes hard to predict what the "correct" result of
      a unit test involving a static variable should be.

    - Concurrency: Java programs can have more than one thread of execution at a time.
      All threads have access to static variables and may manipulate them directly.
      This makes it difficult to ensure that the updates are consistent. Since
      concurrent execution of multiple thread is effectively non-deterministic from
      the application programmer's perspective, such bugs can be hard to detect.


     */
}
