package pij.day10solutions.walkParser;

/**
 * A WalkParseException indicates in which row and column of the input
 * something went wrong with parsing a String to a Point.
 */
public class WalkParseException extends Exception {
    /** Row in which the parse error occurred. */
    private final int errorRow;
    /** Column in which the parse error occurred. */
    private final int errorCol;

    /**
     * Initialises a new WalkParseException with the given row and column as
     * location of the error in the input.
     *
     * @param errorRow the row of the parse error
     * @param errorCol the column of the parse error in the corresponding row
     */
    public WalkParseException(int errorRow, int errorCol) {
        this.errorRow = errorRow;
        this.errorCol = errorCol;
    }

    /**
     * Returns the row in which the error occurred.
     *
     * @return the row in which the error occurred
     */
    public int getErrorRow() {
        return errorRow;
    }

    /**
     * Returns the column in which the error occurred.
     *
     * @return the column in which the error occurred
     */
    public int getErrorCol() {
        return errorCol;
    }
}
