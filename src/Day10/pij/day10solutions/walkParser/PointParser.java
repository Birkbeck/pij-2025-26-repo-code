package pij.day10solutions.walkParser;

import pij.day09.walk.Point;

/**
 * Day 10, Exercise 7.
 * Offers a method to parse a String to a Point.
 */
public class PointParser {

    /**
     * Tries to parse the given String to a corresponding Point object.
     *
     * @param s the String to parse
     * @return the Point corresponding to s
     * @throws PointParseException with details of the error location
     *  if parsing failed
     */
    public Point parse(String s) throws PointParseException {
        final char OPEN = '(';
        final char CLOSE = ')';
        final char COMMA = ',';
        int x, y; // for the new Point

        // first char must be OPEN:
        if (s.charAt(0) != OPEN) {
            throw new PointParseException(0);
        }
        // there should now be at least one char that is potentially part of
        // an int
        int afterXIndex = getFirstIndexAfterIntFrom(s, 1); // 1 is the length of OPEN

        // if a PointParseException occurs in the method call, pass it on
        x = extractInt(s, 1, afterXIndex);

        // the next character should be still in the string and a COMMA
        if (afterXIndex == s.length() || s.charAt(afterXIndex) != COMMA) {
            // + 1 for user presentation (1-based indexing)
            throw new PointParseException(afterXIndex + 1);
        }

        int afterCommaIndex = afterXIndex + 1; // 1 is the length of COMMA
        int afterYIndex = getFirstIndexAfterIntFrom(s, afterCommaIndex);

        y = extractInt(s, afterCommaIndex, afterYIndex);

        // the next character should be still in the string and a CLOSE
        if (afterYIndex == s.length() || s.charAt(afterYIndex) != CLOSE) {
            // + 1 for user presentation (1-based indexing)
            throw new PointParseException(afterYIndex + 1);
        }
        int afterCloseIndex = afterYIndex + 1; // 1 is the length of CLOSE

        // now we should have seen everything in the string
        if (afterCloseIndex != s.length()) {
            // + 1 for user presentation (1-based indexing)
            throw new PointParseException(afterCloseIndex);
        }

        // no parse errors, let's make the desired Point object!
        return new Point(x, y);
    }

    private static int extractInt(String s, int start, int end) throws PointParseException {
        try {
            String xCandidate = s.substring(start, end);
            return Integer.parseInt(xCandidate);
        } catch (NumberFormatException e) {
            // we don't know exactly which character caused the issue, so
            // let's give the index of the first character of the substring
            // that we expected to start an int
            throw new PointParseException(start);
        }
    }

    private static int getFirstIndexAfterIntFrom(String s, int i) {
        for ( ; i < s.length() && isIntCharacter(s.charAt(i)); i++) {
            // no operation
        }
        return i;
    }

    private static boolean isIntCharacter(char c) {
        final char PLUS = '+';
        final char MINUS = '-';
        return Character.isDigit(c) || c == PLUS || c == MINUS;
    }
}
