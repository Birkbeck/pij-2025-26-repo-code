package pij.day06solutions.phones;

/**
 * A MobilePhone models a turn-of-the-millennium mobile telephone
 * with memory for the last called numbers, the capability to
 * play simple games, and alarm functionality.
 */
public class MobilePhone extends OldPhone {

    /** Stores the last called numbers. */
    private final String[] lastCalledNumbers;

    /**
     * Index of the first invalid entry in lastCalledNumber. Relevant
     * as long as the (fixed-size) array has not reached its capacity.
     */
    private int firstInvalidNumber; // initially 0

    private static final int NUMBER_MEMORY_SIZE = 10;

    /**
     * Constructs a new MobilePhone without a brand.
     */
    public MobilePhone() {
        this(OldPhone.NO_BRAND);
    }

    /**
     * Constructs a new MobilePhone with a given brand.
     *
     * @param brand the brand of the MobilePhone
     */
    public MobilePhone(String brand) {
        super(brand);
        lastCalledNumbers = new String[NUMBER_MEMORY_SIZE];
    }

    /**
     * Makes phone call and additionally records number in this MobilePhone's
     * call log.
     *
     * @param number the number to call
     */
    @Override
    public void call(String number) {
        super.call(number);
        // shift all old entries over by one
        for (int i = lastCalledNumbers.length - 1; i > 0; i--) {
            // possible optimisation: check for null
            lastCalledNumbers[i] = lastCalledNumbers[i-1];
        }
        lastCalledNumbers[0] = number;
        if (firstInvalidNumber < lastCalledNumbers.length) {
            firstInvalidNumber++;
        }
        // alternative approaches may involve marking the first valid and the
        // first invalid number; this can avoid moving all elements for each
        // phone call
    }

    /**
     * Rings an alarm with the given message.
     *
     * @param message the given alarm message
     */
    public void ringAlarm(String message) {
        System.out.println("Alarm with: " + message);
    }

    /**
     * Plays a specified game.
     *
     * @param game the game to play
     */
    public void playGame(String game) {
        System.out.println("Playing " + game + "...");
    }

    /**
     * Prints the last 10 phone numbers that were called on the screen.
     */
    public void printLastNumbers() {
        //System.out.println(java.util.Arrays.toString(lastCalledNumbers));
        //for (int i = 0; i < lastCalledNumbers.length; i++) {
        for (int i = 0; i < firstInvalidNumber; i++) {
            System.out.println(lastCalledNumbers[i]);
        }
    }
}
