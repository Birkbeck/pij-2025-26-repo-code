package pij.day10.selfMadeExceptions;

/**
 * A checked exception: it must be caught somewhere.
 */
public class FooException extends Exception {
    public FooException() {
        super();
    }
    public FooException(String message) {
        super(message);
    }
    public FooException(Throwable cause) {
        super(cause);
    }
}
