package ua.com.foxminded.integer.division;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDivision {

    public String makeDivision(int dividend, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        if (Math.abs(divisor) > Math.abs(dividend)) {
            return "Divider modulus greater than dividend. Answer 0";
        }

        int result = dividend / divisor;

        List<Integer> decomposeDividend = decomposeNumberToDigits(dividend);

        int firstCurrentDividend = 0;
        StringBuilder temp = new StringBuilder();

        for (Integer digit : decomposeDividend) {
            temp.append(digit);
            firstCurrentDividend = Integer.parseInt(temp.toString());
            if (firstCurrentDividend >= divisor) {
                break;
            }
        }

        int amountOfDigitsInCurrentDividend = (int) Math.ceil(Math.log10(firstCurrentDividend));
        int firstRemainderDivision;
        int firstMaxIntegerDividend;

        firstRemainderDivision = firstCurrentDividend % divisor;
        firstMaxIntegerDividend = firstCurrentDividend - firstRemainderDivision;

        List<Integer> writeDivision = new ArrayList<>();

        int currentDividendTemp = firstRemainderDivision;

        for (int i = amountOfDigitsInCurrentDividend; i < decomposeDividend.size(); i++) {
            currentDividendTemp = Integer.parseInt(String.valueOf(currentDividendTemp) + decomposeDividend.get(i));

            if (currentDividendTemp >= divisor) {
                int remainderDivisionTemp = currentDividendTemp % divisor;
                int maxIntegerDividendTemp = currentDividendTemp - remainderDivisionTemp;

                writeDivision.add(currentDividendTemp);
                writeDivision.add(maxIntegerDividendTemp);

                currentDividendTemp = remainderDivisionTemp;
            }
        }

        return visualizeResult(dividend, divisor, result, decomposeDividend,
                amountOfDigitsInCurrentDividend, firstMaxIntegerDividend, writeDivision);
    }

    private String visualizeResult(int dividend, int divisor, int result, List<Integer> decomposeDividend,
                                   int amountOfDigitsInCurrentDividend, int firstMaxIntegerDividend, List<Integer> writeDivision) {
        StringBuilder writeResult;
        writeResult = new StringBuilder(("_" + dividend + "|" + divisor + "\n" + " " + firstMaxIntegerDividend +
                String.join("", Collections.nCopies(decomposeDividend.size() - amountOfDigitsInCurrentDividend, " ")) +
                "|-----" + "\n" +
                " -" + String.join("", Collections.nCopies(decomposeDividend.size() - 1, " ")) + "|" + result) + "\n");

        StringBuilder tab1 = new StringBuilder(" ");
        int count = 0;
        for (int i = 0; i < writeDivision.size(); i++) {

            count++;
            if (i == 0 || i == 1) {
                writeResult.append("_").append(writeDivision.get(i)).append("\n").append(" ").append(writeDivision.get(i + 1))
                        .append("\n").append(" --").append("\n");
                i = i + 2;
            }

            if (count % 2 != 0 && (i + 1 <= writeDivision.size())) {
                writeResult.append(tab1).append("_").append(writeDivision.get(i)).append("\n")
                        .append(tab1).append(" ").append(writeDivision.get(i + 1)).append("\n");
            }

            if (count % 2 == 0) {
                writeResult.append(tab1).append(" --").append("\n");
                tab1.append(" ");
            }
        }
        writeResult.append(" ").append(tab1).append(Math.abs(dividend % divisor)).append("\n");
        return writeResult.toString();
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
