package pij.day10solutions.myFirstExceptions;

public class MyCheckedException extends Exception {
    public MyCheckedException() {
        // do nothing beyond the implicit super() call
    }

    public MyCheckedException(String message) {
        super(message);
    }
}
