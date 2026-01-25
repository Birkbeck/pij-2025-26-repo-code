package pij.day18solutions.restaurant;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * A MealOrder can be executed by an ExecutorService to produce a meal.
 * The meal preparation procedure involves printing the first letter of
 * the meal's name on the screen.
 */
public class MealOrder implements Callable<Meal> {

    /** The minimum duration in seconds for preparing a meal (inclusive). */
    public static final int MIN_COOKING_SECONDS = 5;

    /** The maximum duration in seconds for preparing a meal (exclusive). */
    public static final int MAX_COOKING_SECONDS = 20;

    /** Milliseconds for each sleep between the printouts in meal preparation. */
    public static final int SLEEP_MILLIS = 500;

    /** The name of the dish. Non-null. */
    private final String dishName;

    /**
     * The cooking time of this meal order in seconds. At least
     * MIN_COOKING_SECONDS seconds (inclusive), at most MIN_COOKING_SECONDS
     * seconds (exclusive).
     */
    private final int cookingTimeSeconds;

    /**
     * Initialises a new MealOrder with a given name and a randomly generated
     * cooking time in seconds. The latter is at least MIN_COOKING_SECONDS
     * seconds (inclusive), at most MIN_COOKING_SECONDS seconds (exclusive).
     *
     * @param dishName the name for the ordered meal
     * @throws NullPointerException if dishName is null
     */
    public MealOrder(String dishName) {
        this.dishName = Objects.requireNonNull(dishName);
        Random random = new Random();
        this.cookingTimeSeconds = random.nextInt(MIN_COOKING_SECONDS, MAX_COOKING_SECONDS);
        // alternatively, the random duration for the meal preparation
        // may be determined by the Restaurant object and passed via
        // ... = new MealOrder(dishName, cookingTimeSeconds);
    }

    /**
     * Tries to cook the ordered Meal.
     *
     * @return the cooked Meal if successful
     * @throws InterruptedException if the attempt to let our thread sleep
     *                              gets interrupted
     * @throws IndexOutOfBoundsException if the dish name passed to the
     *                                   constructor has length 0
     */
    @Override
    public Meal call() throws InterruptedException {
        int pendingMillis = this.cookingTimeSeconds * 1000;
        while (pendingMillis > 0) {
            pendingMillis -= SLEEP_MILLIS;
            // the next line may throw an exception if this.dishName.isEmpty();
            // this is deliberate (the cook does not know how to cook a meal
            // with an empty name)
            System.out.print(this.dishName.charAt(0));
            Thread.sleep(SLEEP_MILLIS);
        }
        return new Meal(this.dishName);
    }
}
