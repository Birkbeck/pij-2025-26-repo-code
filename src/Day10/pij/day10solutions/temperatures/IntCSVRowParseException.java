package pij.day10solutions.temperatures;

/**
 * A RowParseException indicates at which position of the input something
 * went wrong with parsing a row of a CSV file with int values.
 */
public class IntCSVRowParseException extends Exception {
    /** The position at which parsing failed. */
    private final int errorIndex;

    /**
     * Initialises the PointParseException with the given position at which
     * parsing failed.
     *
     * @param errorIndex the position at which parsing failed
     */
    public IntCSVRowParseException(int errorIndex) {
        this.errorIndex = errorIndex;
    }

    /**
     * Returns the position at which parsing failed.
     *
     * @return the position at which parsing failed
     */
    public int getErrorIndex() {
        return errorIndex;
    }
}
