package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.Result;

import java.util.Collections;

public class ClassicFormatter implements Formatter {

    @Override
    public StringBuilder format(Result result) {

        StringBuilder output;
        if (result.getDividend() > 0) {
            output = new StringBuilder(("_" + result.getDividend() + "|" + result.getDivisor()
                    + "\n" + " " + result.getFirstGreatestCommonDivisor() + String.join("",
                    Collections.nCopies(result.getDecomposeDividend().size() - result.getAmountOfDigitsInFirstPartialDividend(), " ")) +
                    "|-----" + "\n" +
                    " -" + String.join("", Collections.nCopies(result.getDecomposeDividend().size() - 1, " "))
                    + "|" + result.getResultDivision()) + "\n");
            StringBuilder tab1 = new StringBuilder(" ");
            int count = 0;
            for (int i = 0; i < result.getWriteDivision().size(); i++) {

                count++;
                if (i == 0 || i == 1) {
                    output.append("_").append(result.getWriteDivision().get(i)).append("\n").append(" ").append(result.getWriteDivision().get(i + 1))
                            .append("\n").append(" --").append("\n");
                    i = i + 2;
                }

                if (count % 2 != 0 && (i + 1 <= result.getWriteDivision().size())) {
                    output.append(tab1).append("_").append(result.getWriteDivision().get(i)).append("\n")
                            .append(tab1).append(" ").append(result.getWriteDivision().get(i + 1)).append("\n");
                }

                if (count % 2 == 0) {
                    output.append(tab1).append(" --").append("\n");
                    tab1.append(" ");
                }

            }
            output.append(" ").append(tab1).append(Math.abs(result.getDividend() % result.getDivisor())).append("\n");

        } else {
            output = new StringBuilder(("_" + result.getDividend() + "|" + result.getDivisor()
                    + "\n" + "  " + result.getFirstGreatestCommonDivisor() + String.join("",
                    Collections.nCopies(result.getDecomposeDividend().size() - result.getAmountOfDigitsInFirstPartialDividend(), " ")) +
                    "|-----" + "\n" +
                    "  -" + String.join("", Collections.nCopies(result.getDecomposeDividend().size() - 1, " "))
                    + "|" + result.getResultDivision()) + "\n");


            StringBuilder tab1 = new StringBuilder(" ");
            int count = 0;
            for (int i = 0; i < result.getWriteDivision().size(); i++) {

                count++;
                if (i == 0 || i == 1) {
                    output.append(" " + "_").append(result.getWriteDivision().get(i)).append("\n").append("  ").append(result.getWriteDivision().get(i + 1))
                            .append("\n").append(" --").append("\n");
                    i = i + 2;
                }

                if (count % 2 != 0 && (i + 1 <= result.getWriteDivision().size())) {
                    output.append(tab1).append("" + "_").append(result.getWriteDivision().get(i)).append("\n")
                            .append(tab1).append(" ").append(result.getWriteDivision().get(i + 1)).append("\n");
                }

                if (count % 2 == 0) {
                    output.append(tab1).append(" --").append("\n");
                    tab1.append(" ");
                }
            }
            output.append("  ").append(tab1).append(Math.abs(result.getDividend() % result.getDivisor())).append("\n");
        }
        return output;
    }
}
