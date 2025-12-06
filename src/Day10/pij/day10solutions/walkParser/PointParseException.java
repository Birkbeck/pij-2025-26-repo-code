package pij.day10solutions.walkParser;

/**
 * A PointParseException indicates at which position of the input something
 * went wrong with parsing a String to a Point.
 */
public class PointParseException extends Exception {
    /** The position at which parsing failed. */
    private final int errorIndex;

    /**
     * Initialises the PointParseException with the given position at which
     * parsing failed.
     *
     * @param errorIndex the position at which parsing failed
     */
    public PointParseException(int errorIndex) {
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
