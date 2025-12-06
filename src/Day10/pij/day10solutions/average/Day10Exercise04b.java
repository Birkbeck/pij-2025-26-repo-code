package pij.day10solutions.average;

import java.util.Scanner;

// Exercise 4, part b.
public class Day10Exercise04b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Day10Exercise04a.getInput(scan,
                "How many numbers do you want to enter?");
        double avg = Day10Exercise04a.readNumbersAndComputeAverage(scan, count);
        System.out.println("The average is: " + avg);

    }
}
