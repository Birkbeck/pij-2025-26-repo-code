package pij.day10solutions.myFirstExceptions;

import java.util.Scanner;

// Exercise 6
public class MyExceptionRunner {

    private static final int CHECKED_INSIDE = 1;
    private static final int CHECKED_OUTSIDE = 2;
    private static final int UNCHECKED_INSIDE = 3;
    private static final int UNCHECKED_OUTSIDE = 4;

    private static int getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose your exception flavour!");
        System.out.println("Enter " + CHECKED_INSIDE +
                " for a checked exception from inside a try block.");
        System.out.println("Enter " + CHECKED_OUTSIDE +
                " for a checked exception from outside a try block.");
        System.out.println("Enter " + UNCHECKED_INSIDE +
                " for an unchecked exception from inside a try block.");
        System.out.println("Enter " + UNCHECKED_OUTSIDE +
                " for an unchecked exception from outside a try block.");
        return scan.nextInt();
    }

    /**
     * Fun with exceptions!
     *
     * @throws MyCheckedException may be thrown if the user chooses this
     * @throws MyUncheckedException may be thrown if the user chooses this
     */
    private static void launch() throws MyCheckedException {
        // "throws MyCheckedException" had to be added because we may throw
        // an instance of this kind of checked exception in the method
        int choice = getInput();
        switch (choice) {
            case CHECKED_INSIDE:
                try {
                    throw new MyCheckedException("I am a checked exception and I have been thrown from inside a try block");
                } catch (MyCheckedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case CHECKED_OUTSIDE:
                throw new MyCheckedException("I am a checked exception and I have been thrown from outside a try block");
            case UNCHECKED_INSIDE:
                try {
                    throw new MyUncheckedException("I am an unchecked exception and I have been thrown from inside a try block");
                } catch (MyUncheckedException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case UNCHECKED_OUTSIDE:
                throw new MyUncheckedException("I am an unchecked exception and I have been thrown from outside a try block");
            default:
                System.out.println("I don't know what to do with choice " + choice + "!");
        }
    }

    public static void main(String[] args) {
        // try ... catch block had to be added because launch() throws
        // MyCheckedException, and this method *must* either catch it
        // or declare that it throws it; we have chosen to catch it
        try {
            launch();
        } catch (MyCheckedException e) {
            System.out.println(e.getMessage());
        }
    }
}
