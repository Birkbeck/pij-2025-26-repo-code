package pij.day12solutions.fibonacci;

import org.junit.jupiter.api.Test;
import pij.day12.fibonacci.FibonacciTry1;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTry1Test {

    private static final int SHORT_DURATION_MILLIS = 1000;
    private static final int LONG_DURATION_MILLIS = 600000;

    @Test
    void testFib0() {
        int input = 0;
        long expected = 0;
        FibonacciTry1 f = new FibonacciTry1();
        long actual = f.fib(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFib1() {
        int input = 1;
        long expected = 1;
        FibonacciTry1 f = new FibonacciTry1();
        long actual = f.fib(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFib2() {
        int input = 2;
        long expected = 1;
        FibonacciTry1 f = new FibonacciTry1();
        long actual = f.fib(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFib6() {
        int input = 6;
        long expected = 8;
        FibonacciTry1 f = new FibonacciTry1();
        long actual = f.fib(input);
        assertEquals(expected, actual);
    }

    @Test
    void testFibNegative() {
        FibonacciTry1 f = new FibonacciTry1();

        assertThrows(IllegalArgumentException.class, () -> {
            f.fib(-1);
        });
    }

    @Test
    void testFib46ShortTimeout() {
        int input = 46;
        long expected = 1836311903;
        FibonacciTry1 f = new FibonacciTry1();
        assertTimeout(Duration.ofMillis(SHORT_DURATION_MILLIS), () -> {
            // test fails due to timeout, but completes evaluation of f.fib(46)
            long actual = f.fib(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    void testFib46ShortTimeoutPreemptively() {
        int input = 46;
        long expected = 1836311903;
        FibonacciTry1 f = new FibonacciTry1();
        assertTimeoutPreemptively(Duration.ofMillis(SHORT_DURATION_MILLIS), () -> {
            // test fails due to timeout, stops evaluation of f.fib(46) when timeout is reached
            long actual = f.fib(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    void testFib46LongTimeout() {
        int input = 46;
        long expected = 1836311903;
        FibonacciTry1 f = new FibonacciTry1();
        assertTimeout(Duration.ofMillis(LONG_DURATION_MILLIS), () -> {
            long actual = f.fib(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    void testFib46LongTimeoutPreemptively() {
        int input = 46;
        long expected = 1836311903;
        FibonacciTry1 f = new FibonacciTry1();
        assertTimeoutPreemptively(Duration.ofMillis(LONG_DURATION_MILLIS), () -> {
            long actual = f.fib(input);
            assertEquals(expected, actual);
        });
    }
}