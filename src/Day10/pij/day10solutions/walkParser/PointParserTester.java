package pij.day10solutions.walkParser;

import pij.day09.walk.Point;

/**
 * Driver class for PointParser. Tries to parse legal and illegal inputs.
 */
public class PointParserTester {

    /**
     * Parses and prints the given String that presumably represents a Point.
     * If parsing fails, prints an error message indicating the location at
     * which parsing failed.
     *
     * @param pointParser the parser to use
     * @param s the String that we try to parse
     */
    public static void tryToParse(PointParser pointParser, String s) {
        try {
            Point p = pointParser.parse(s);
            System.out.println("Point parsed: " + p);
        } catch (PointParseException e) {
            System.out.println("Parsing " + s + " failed at index " + e.getErrorIndex());
        }
    }

    /**
     * @param args Ignored.
     */
    public static void main(String[] args) {
        PointParser pointParser = new PointParser();
        tryToParse(pointParser, "(42,-523)"); // legal
        tryToParse(pointParser, "(1,2))"); // illegal
        tryToParse(pointParser, "(1,)"); // illegal
    }
}
