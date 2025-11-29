package pij.day08solutions.overloadingExercise;

public class SumPrinterSolution {

    public static void printSum(int x, int y, String prefix) {
        int sum = x + y;
        System.out.println(prefix + sum);
    }

    public static void printSum(int x, int y) {
        printSum(x, y, x + " + " + y + " = ");
    }

    public static void printSum(String x, String y) {
        int xInt = Integer.parseInt(x);
        int yInt = Integer.parseInt(y);
        printSum(xInt, yInt);
    }
}

