package pij.day10solutions.walkParser;

import pij.day09.walk.Walk;

import java.io.File;
import java.io.IOException;

/**
 * Driver class for WalkParser.
 */
public class WalkParserTester {

    /**
     * @param args Ignored.
     */
    public static void main(String[] args) {
        //System.out.println(f.getAbsolutePath());
        File f = new File("src/Day10/pij/day10/walkParser/walkOk1.txt");
        //File f = new File("src/Day10/pij/day10/walkParser/walkOk2.txt");
        //File f = new File("src/Day10/pij/day10/walkParser/walkNotOk1.txt");
        //File f = new File("src/Day10/pij/day10/walkParser/walkNotOk2.txt");
        WalkParser walkParser = new WalkParser();
        try {
            Walk walk = walkParser.parse(f);
            System.out.println(walk);
        } catch (WalkParseException e) {
            System.out.println("Parse error in line " + e.getErrorRow() +
                    " and column " + e.getErrorCol());
        } catch (IOException e) {
            System.out.println("Something went wrong when reading the file.");
            System.out.println(e.getMessage());
        }
    }
}