package pij.day10solutions.myFirstExceptions;

public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException() {
        // do nothing beyond the implicit super() call
    }

    public MyUncheckedException(String message) {
        super(message);
    }
}
