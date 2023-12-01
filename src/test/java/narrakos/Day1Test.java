package narrakos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    Day1 day1;

    @BeforeEach
    void setUp() {
        day1 = new Day1();
    }

    @Test
    void solvePartOne() {
        final int expected = 56506;
        final int actual = day1.solvePartOne();
        assertEquals(expected, actual);
    }

    @Test
    void solvePartTwo() {
        final int expected = 56017;
        final int actual = day1.solvePartTwo();
        assertEquals(expected, actual);
    }
}