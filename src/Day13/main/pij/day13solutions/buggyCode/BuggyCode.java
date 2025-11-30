package pij.day13solutions.buggyCode;

// Exercise 1
public class BuggyCode {
    public static String buggyMethod(int n) {
        //if (n == 0) { // leads to infinite recursion if n is an odd number or negative
        if (n <= 0) {
            return "";
        }
        return n + " " + buggyMethod(n-2);
    }
}
