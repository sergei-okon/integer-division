package ua.com.foxminded.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.model.Result;

import static org.junit.jupiter.api.Assertions.*;

class ClassicFormatterTest {
    Divider divider;
    Formatter formatter;

    @BeforeEach
    public void setUp() {
        divider = new Divider();
        formatter = new ClassicFormatter();
    }

    @Test
    void format_ShouldSuccess_whenDivisorOfOneDigit() {
        Result result = divider.divide(78945, 4);
        StringBuilder output = formatter.format(result);

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

        assertEquals(expected, output.toString());
    }

    @Test
    void format_ShouldSuccess_whenDivisorOfTwoDigits() {
        Result result = divider.divide(78945, 12);
        StringBuilder output = formatter.format(result);

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

        assertEquals(expected, output.toString());
    }

    @Test
    void format_ShouldSuccess_whenDivisorNegative() {
        Result result = divider.divide(78945, -12);
        StringBuilder output = formatter.format(result);

        String expected = "_78945|-12\n" +
                " 72   |-----\n" +
                " -    |-6578\n" +
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

        assertEquals(expected, output.toString());
    }

    @Test
    void format_ShouldSuccess_whenDividendNegative() {
        Result result = divider.divide(-78945, 12);
        StringBuilder output = formatter.format(result);

        String expected = "_-78945|12\n" +
                "  72   |-----\n" +
                "  -    |-6578\n" +
                " _69\n" +
                "  60\n" +
                " --\n " +
                "_94\n" +
                "  84\n" +
                "  --\n" +
                "  _105\n" +
                "   96\n" +
                "   --\n" +
                "     9\n";

        assertEquals(expected, output.toString());
    }

    @Test
    void format_ShouldSuccess_whenDividendAndDivisorNegative() {
        Result result = divider.divide(-78945, -12);
        StringBuilder output = formatter.format(result);

        String expected = "_-78945|-12\n" +
                "  72   |-----\n" +
                "  -    |6578\n" +
                " _69\n" +
                "  60\n" +
                " --\n " +
                "_94\n" +
                "  84\n" +
                "  --\n" +
                "  _105\n" +
                "   96\n" +
                "   --\n" +
                "     9\n";

        assertEquals(expected, output.toString());
    }
}