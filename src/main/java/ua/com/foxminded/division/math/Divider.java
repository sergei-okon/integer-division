package ua.com.foxminded.division.math;

import ua.com.foxminded.division.model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divider {

    public Result divide(int dividend, int divisor) {
        Result result = new Result();
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        if (Math.abs(divisor) > Math.abs(dividend)) {
            throw new IllegalArgumentException("Divider modulus greater than dividend. Answer 0");
        }

        int resultDivision = dividend / divisor;

        result.setDividend(dividend);
        result.setDivisor(divisor);
        result.setResultDivision(resultDivision);

        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        List<Integer> decomposeDividend = decomposeNumberToDigits(dividend);

        int firstPartialDividend = 0;

        StringBuilder temp = new StringBuilder();

        for (Integer digit : decomposeDividend) {
            temp.append(digit);
            firstPartialDividend = Integer.parseInt(temp.toString());
            if (firstPartialDividend >= divisor) {
                break;
            }
        }

        int amountOfDigitsInFirstPartialDividend = (int) Math.ceil(Math.log10(firstPartialDividend));
        int firstRemainder;
        int firstGreatestCommonDivisor;

        firstRemainder = firstPartialDividend % divisor;
        firstGreatestCommonDivisor = firstPartialDividend - firstRemainder;

        List<Integer> writeDivision = new ArrayList<>();

        int partialDividendTemp = firstRemainder;

        for (int i = amountOfDigitsInFirstPartialDividend; i < decomposeDividend.size(); i++) {
            partialDividendTemp = Integer.parseInt(String.valueOf(partialDividendTemp) + decomposeDividend.get(i));

            if (partialDividendTemp >= divisor) {
                int remainderTemp = partialDividendTemp % divisor;
                int greatestCommonDivisorTemp = partialDividendTemp - remainderTemp;

                writeDivision.add(partialDividendTemp);
                writeDivision.add(greatestCommonDivisorTemp);

                partialDividendTemp = remainderTemp;
            }
        }

        result.setDecomposeDividend(decomposeDividend);
        result.setAmountOfDigitsInFirstPartialDividend(amountOfDigitsInFirstPartialDividend);
        result.setFirstGreatestCommonDivisor(firstGreatestCommonDivisor);
        result.setWriteDivision(writeDivision);

        return result;
    }

    private List<Integer> decomposeNumberToDigits(int number) {
        number = Math.abs(number);
        List<Integer> digits = new ArrayList<>();
        int countDigitsInNumber = String.valueOf(Math.abs(number)).length();
        int counter = 1;

        while (countDigitsInNumber > 0) {
            int i = number / counter % 10;
            digits.add(Math.abs(i));
            counter = counter * 10;
            countDigitsInNumber--;
        }
        Collections.reverse(digits);

        return digits;
    }
}
