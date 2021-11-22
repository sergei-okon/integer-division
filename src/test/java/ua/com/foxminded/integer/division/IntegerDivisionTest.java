package ua.com.foxminded.integer.division;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionTest {
    IntegerDivision integerDivision;

    @BeforeEach
    public void setUp() {
        integerDivision = new IntegerDivision();
    }

    @Test
    void makeDivision_ShouldException_whenDivisorZero() {
        assertThrows(IllegalArgumentException.class, () ->
                integerDivision.makeDivision(94545, 0));
    }

    @Test
    void makeDivision_ShouldSuccess_whenDivisorGreaterDividend() {

        String expected = "Divider modulus greater than dividend. Answer 0";

        assertEquals(expected, integerDivision.makeDivision(456, 555));
    }

    @Test
    void makeDivision_ShouldSuccess_whenDivisorOfOneDigit() {

        String expected = "_78945|4\n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n " +
                "_29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";

        assertEquals(expected, integerDivision.makeDivision(78945, 4));
    }

    @Test
    void makeDivision_ShouldSuccess_whenDivisorOfTwoDigits() {

        String expected = "_78945|12\n" +
                " 72   |-----\n" +
                " -    |6578\n" +
                "_69\n" +
                " 60\n" +
                " --\n " +
                "_94\n" +
                "  84\n" +
                "  --\n" +
                "  _105\n" +
                "   96\n" +
                "   --\n" +
                "    9\n";

        assertEquals(expected, integerDivision.makeDivision(78945, 12));
    }

    @Test
    void makeDivision_ShouldSuccess_whenDivisorGreaterThanFirstDigitDividend() {

        String expected = "_78945|8\n" +
                " 72   |-----\n" +
                " -    |9868\n" +
                "_69\n" +
                " 64\n" +
                " --\n " +
                "_54\n" +
                "  48\n" +
                "  --\n" +
                "  _65\n" +
                "   64\n" +
                "   --\n" +
                "    1\n";

        assertEquals(expected, integerDivision.makeDivision(78945, 8));
    }

    @Test
    void makeDivision_ShouldSuccess_whenDivisorOfThreeDigitsAndGreaterThanThreeDigitsDividend() {

        String expected = "_4124456|456\n" +
                " 4104   |-----\n" +
                " -      |9044\n" +
                "_2045\n" +
                " 1824\n" +
                " --\n " +
                "_2216\n" +
                "  1824\n" +
                "  --\n" +
                "   392\n";

        assertEquals(expected, integerDivision.makeDivision(4124456, 456));
    }
}
