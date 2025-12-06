package pij.day10solutions.average;

import java.util.Scanner;

// Exercise 4, part a.
public class Day10Exercise04a {

    public static int getInput(Scanner scan, String message) {
        while (true) {
            try {
                System.out.println(message);
                String s = scan.nextLine();
                int next = Integer.parseInt(s);
                return next;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " is not an int!");
            }
        }
    }
    
    public static double readNumbersAndComputeAverage(Scanner scan, int count) {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += getInput(scan, "Please enter number " + (i+1) + "!");
        }
        return sum / count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double avg = readNumbersAndComputeAverage(scan, 10);
        System.out.println("The average is: " + avg);
    }
}
