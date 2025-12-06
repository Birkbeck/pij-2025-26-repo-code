package pij.day10solutions.temperatures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Offers a method to parse a String with comma-separated values, each of
 * which representing an int, to List<List<Integer>> format.
 */
public class IntCSVParser {

    /** The separator String to expect between values in a line. */
    private static final String SEPARATOR = ",";

    /**
     * Tries to parse the given String to a corresponding List<List<Integer>>.
     *
     * @param s the String to parse
     * @return the List<List<Integer>> corresponding to s
     * @throws IntCSVParseException with details of the error location
     *  if parsing failed
     */
    public List<List<Integer>> parse(String s) throws IntCSVParseException {
        List<List<Integer>> result = new ArrayList<>();
        String[] split = s.split("\n");
        for (int row = 0; row < split.length; row++) {
            try {
                List<Integer> rowList = parseRow(split[row]);
                result.add(rowList);
            } catch (IntCSVRowParseException e) {
                int col = e.getErrorIndex();
                // + 1 for user presentation (1-based indexing)
                throw new IntCSVParseException(row + 1, col);
            }
        }
        return result;
    }

    /**
     * Tries to parse a single line of a CSV String that presumably contains
     * int values only.
     *
     * @param line the line to parse
     * @return the corresponding list of int values
     * @throws IntCSVRowParseException with details of the error location
     *  if parsing failed
     */
    private List<Integer> parseRow(String line) throws IntCSVRowParseException {
        List<Integer> result = new ArrayList<>();
        String[] entries = line.split(SEPARATOR);
        int currentIndex = 0; // we need the current location in case of a parse error
        for (String entry : entries) {
            try {
                int value = Integer.parseInt(entry);
                result.add(value);
            } catch (NumberFormatException e) {
                // + 1 for user presentation (1-based indexing)
                throw new IntCSVRowParseException(currentIndex + 1);
            }
            // go to the start of the next entry in the String
            currentIndex += entry.length() + SEPARATOR.length();
        }
        return result;
    }

    /**
     * Tries to parse the content of the given file to a corresponding
     * List<List<Integer>>.
     *
     * @param f the file to parse
     * @return the List<List<Integer>> corresponding to s
     * @throws IntCSVParseException with details of the error location
     *  if parsing failed
     * @throws IOException if the file could not be read successfully
     * @throws NullPointerException if f is null
     */
    public List<List<Integer>> parse(File f) throws IntCSVParseException, IOException {
        Path p = f.toPath();
        String s = Files.readString(p);
        return parse(s);
    }
}
