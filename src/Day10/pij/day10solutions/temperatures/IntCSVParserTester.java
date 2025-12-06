package pij.day10solutions.temperatures;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Driver class for IntCSVParser.
 */
public class IntCSVParserTester {

    /**
     * @param args Ignored.
     */
    public static void main(String[] args) {
        //System.out.println(f.getAbsolutePath());
        File f = new File("src/Day10/pij/day10/temperatures/temperaturesOk1.csv");
        //File f = new File("src/Day10/pij/day10/temperatures/temperaturesOk2.csv");
        //File f = new File("src/Day10/pij/day10/temperatures/temperaturesNotOk1.csv");
        //File f = new File("src/Day10/pij/day10/temperatures/temperaturesNotOk2.csv");
        IntCSVParser intCSVParser = new IntCSVParser();
        try {
            List<List<Integer>> matrix = intCSVParser.parse(f);
            System.out.println(matrix);
        } catch (IntCSVParseException e) {
            System.out.println("Parse error in line " + e.getErrorRow() +
                    " and column " + e.getErrorCol());
        } catch (IOException e) {
            System.out.println("Something went wrong when reading the file.");
            System.out.println(e.getMessage());
        }
    }
}