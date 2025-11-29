package pij.day06solutions.printEven;

public class EvenPrinter /* extends String */ {
    // Ex 9:
    // If we remove the above /* */, we get a message like:
    // Cannot inherit from final 'java.lang.String'.
    // String is indeed a final class, so it is not allowed to have subclasses.

    // The below code uses delegation instead of making a subclass for the
    // intended goal. (This was *not* required by the exercise, but shows
    // how to deal with such a situation.)

    private final String baseString;

    /**
     * Constructs a new EvenPrinter for the constructor parameter.
     *
     * @param baseString the string whose even positions we want to be able to
     *                   print.
     */
    public EvenPrinter(String baseString) {
        this.baseString = baseString;
    }

    /**
     * Prints the content of the even positions of the String
     * encapsulated in this EvenPrinter.
     */
    public void printEven() {
        // StringBuilder is a mutable alternative to String, useful for
        // building a String object step by step
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseString.length(); i += 2) {
            sb.append(baseString.charAt(i));
        }
        System.out.println(sb);
    }
}
