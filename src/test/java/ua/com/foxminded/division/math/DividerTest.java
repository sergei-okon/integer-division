package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DividerTest {
    Divider divider;

    @BeforeEach
    public void setUp() {
        divider = new Divider();
    }

    @Test
    void divide_ShouldException_whenDivisorZero() {
        assertThrows(IllegalArgumentException.class, () ->
                divider.divide(78945, 0));
    }

    @Test
    void divide_ShouldSuccess_whenDivisorGreaterDividend() {
        assertThrows(IllegalArgumentException.class, () ->
                divider.divide(456, 555));
    }

    @Test
    void divide_ShouldMadeObjectResult_whenArgsIsCorrect() {
        List<Integer> decomposeDividend = new ArrayList<>(Arrays.asList(7, 8, 9, 4, 5));
        List<Integer> writeDivision = new ArrayList<>(Arrays.asList(38, 36, 29, 28, 14, 12, 25, 24));

        Result expected = new Result(78945, 4, 19736, decomposeDividend, 1,
                4, writeDivision);

        Result actual = divider.divide(78945, 4);
        assertEquals(expected.getDividend(), actual.getDividend());
        assertEquals(expected.getWriteDivision(), actual.getWriteDivision());
        assertEquals(expected.getResultDivision(), actual.getResultDivision());
        assertEquals(expected.getAmountOfDigitsInFirstPartialDividend(), actual.getAmountOfDigitsInFirstPartialDividend());
    }

    @Test
    void divide_ShouldMadeObjectResult_whenDividendIsNegative() {
        List<Integer> decomposeDividend = new ArrayList<>(Arrays.asList(7, 8, 9, 4, 5));
        List<Integer> writeDivision = new ArrayList<>(Arrays.asList(38, 36, 29, 28, 14, 12, 25, 24));

        Result expected = new Result(-78945, 4, -19736, decomposeDividend, 1,
                4, writeDivision);

        Result actual = divider.divide(-78945, 4);
        assertEquals(expected.getDividend(), actual.getDividend());
        assertEquals(expected.getWriteDivision(), actual.getWriteDivision());
        assertEquals(expected.getResultDivision(), actual.getResultDivision());
        assertEquals(expected.getAmountOfDigitsInFirstPartialDividend(), actual.getAmountOfDigitsInFirstPartialDividend());
    }

    @Test
    void divide_ShouldMadeObjectResult_whenDivisorIsNegative() {
        List<Integer> decomposeDividend = new ArrayList<>(Arrays.asList(7, 8, 9, 4, 5));
        List<Integer> writeDivision = new ArrayList<>(Arrays.asList(38, 36, 29, 28, 14, 12, 25, 24));

        Result expected = new Result(78945, -4, -19736, decomposeDividend, 1,
                4, writeDivision);

        Result actual = divider.divide(78945, -4);
        assertEquals(expected.getDividend(), actual.getDividend());
        assertEquals(expected.getWriteDivision(), actual.getWriteDivision());
        assertEquals(expected.getResultDivision(), actual.getResultDivision());
        assertEquals(expected.getAmountOfDigitsInFirstPartialDividend(), actual.getAmountOfDigitsInFirstPartialDividend());
    }

    @Test
    void divide_ShouldMadeObjectResult_whenDividendAndDivisorAreNegative() {
        List<Integer> decomposeDividend = new ArrayList<>(Arrays.asList(7, 8, 9, 4, 5));
        List<Integer> writeDivision = new ArrayList<>(Arrays.asList(38, 36, 29, 28, 14, 12, 25, 24));

        Result expected = new Result(-78945, -4, 19736, decomposeDividend, 1,
                4, writeDivision);

        Result actual = divider.divide(-78945, -4);
        assertEquals(expected.getDividend(), actual.getDividend());
        assertEquals(expected.getWriteDivision(), actual.getWriteDivision());
        assertEquals(expected.getResultDivision(), actual.getResultDivision());
        assertEquals(expected.getAmountOfDigitsInFirstPartialDividend(), actual.getAmountOfDigitsInFirstPartialDividend());
    }
}