package pij.day10solutions.temperatures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day 10, Exercise 8.
 * Analyser for a CSV file with temperature data.
 */
public class TemperatureAnalyser {

    /**
     * Reports the average of the lines and the average of the averages of
     * the lines of an input file in CSV format with int entries.
     *
     * @param inputFileName the name of the input file
     * @throws NullPointerException if inputFileName is null
     */
    private static void analyse(String inputFileName) {
        // first parse the input file ...
        IntCSVParser parser = new IntCSVParser();
        File inputFile = new File(inputFileName);
        List<List<Integer>> matrix = null;
        try {
            matrix = parser.parse(inputFile);
        } catch (IntCSVParseException e) {
            System.out.println("Parse error in line " + e.getErrorRow() +
                    " and column " + e.getErrorCol());
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong when reading the file: " +
                    inputFileName);
            System.out.println(e.getMessage());
            return;
        }

        // ... now do the actual analysis ...
        List<Double> averages = getAverages(matrix);
        double totalAverage = getAverage(averages);

        // ... and report the result
        System.out.println("Averages per line: " + averages);
        System.out.println("Average of averages: " + totalAverage);
    }

    private static List<Double> getAverages(List<List<Integer>> matrix) {
        List<Double> result = new ArrayList<>();
        for (List<Integer> row : matrix) {
            double average = getAverage(row);
            result.add(average);
        }
        return result;
    }

    /**
     * @param numbers the numbers whose average we want
     * @return the average of the numbers in the given list, NaN if the list
     *  is empty
     * @throws NullPointerException if numbers is or contains null
     */
    private static double getAverage(List<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.size(); // NaN for division by zero
    }

    public static void main(String[] args) {
        String inputFile = "src/Day10/pij/day10/temperatures/temperaturesOk1.csv";
        analyse(inputFile);
    }
}
