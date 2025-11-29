package pij.day08solutions.overloadingExercise;

import pij.day08.overloadingExercise.SumPrinter;

public class SumPrinterRunner {

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        String a = "4";
        String b = "5";
        String prefix = "Hello!";
        SumPrinter.printSum(x, y);
        SumPrinterSolution.printSum(x, y);
        SumPrinter.printSum(x, y, prefix);
        SumPrinterSolution.printSum(x, y, prefix);
        SumPrinter.printSum(a, b);
        SumPrinterSolution.printSum(a, b);

    }
}
