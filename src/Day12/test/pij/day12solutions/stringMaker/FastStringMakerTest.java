package pij.day12solutions.stringMaker;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class FastStringMakerTest {

    private static final int LARGE_INPUT = 200000;
    private static final int SHORT_TIMEOUT_MILLIS = 1000;

    @Test
    void testLargeInput() {
        assertTimeout(Duration.ofMillis(SHORT_TIMEOUT_MILLIS), () -> {
            FastStringMaker.build(LARGE_INPUT);
        });
    }
}