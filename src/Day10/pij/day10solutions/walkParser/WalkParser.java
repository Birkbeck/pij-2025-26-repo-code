package pij.day10solutions.walkParser;

import pij.day09.walk.Point;
import pij.day09.walk.Walk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Day 10, Exercise 7.
 * Offers a method to parse a String to a Walk.
 */
public class WalkParser {

    /**
     * Tries to parse the given String to a corresponding Walk object.
     *
     * @param s the String to parse
     * @return the Point corresponding to s
     * @throws WalkParseException with details of the error location
     *  if parsing failed
     */
    public Walk parse(String s) throws WalkParseException {
        Walk result = new Walk();
        PointParser pointParser = new PointParser(); // auxiliary parser
        String[] split = s.split("\n");
        for (int row = 0; row < split.length; row++) {
            try {
                Point p = pointParser.parse(split[row]);
                result.extend(p);
            } catch (PointParseException e) {
                int col = e.getErrorIndex();
                // row + 1 for user presentation (1-based indexing)
                throw new WalkParseException(row + 1, col);
            }
        }
        return result;
    }

    /**
     * Tries to parse the content of the given file to a corresponding Walk
     * object.
     *
     * @param f the file to parse
     * @return the Point corresponding to s
     * @throws WalkParseException with details of the error location
     *  if parsing failed
     * @throws IOException if the file could not be read successfully
     * @throws NullPointerException if f is null
     */
    public Walk parse(File f) throws WalkParseException, IOException {
        Path p = f.toPath();
        String s = Files.readString(p);
        return parse(s);
    }
}
