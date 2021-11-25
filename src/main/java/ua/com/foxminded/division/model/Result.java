package ua.com.foxminded.division.model;

import java.util.List;

public class Result {
    private int dividend;
    private int divisor;
    private int resultDivision;
    private List<Integer> decomposeDividend;
    private int amountOfDigitsInFirstPartialDividend;
    private int firstGreatestCommonDivisor;
    private List<Integer> writeDivision;

    public Result() {
    }

    public Result(int dividend, int divisor, int resultDivision, List<Integer> decomposeDividend, int amountOfDigitsInFirstPartialDividend, int firstGreatestCommonDivisor, List<Integer> writeDivision) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.resultDivision = resultDivision;
        this.decomposeDividend = decomposeDividend;
        this.amountOfDigitsInFirstPartialDividend = amountOfDigitsInFirstPartialDividend;
        this.firstGreatestCommonDivisor = firstGreatestCommonDivisor;
        this.writeDivision = writeDivision;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getResultDivision() {
        return resultDivision;
    }

    public void setResultDivision(int resultDivision) {
        this.resultDivision = resultDivision;
    }

    public List<Integer> getDecomposeDividend() {
        return decomposeDividend;
    }

    public void setDecomposeDividend(List<Integer> decomposeDividend) {
        this.decomposeDividend = decomposeDividend;
    }

    public int getAmountOfDigitsInFirstPartialDividend() {
        return amountOfDigitsInFirstPartialDividend;
    }

    public void setAmountOfDigitsInFirstPartialDividend(int amountOfDigitsInFirstPartialDividend) {
        this.amountOfDigitsInFirstPartialDividend = amountOfDigitsInFirstPartialDividend;
    }

    public int getFirstGreatestCommonDivisor() {
        return firstGreatestCommonDivisor;
    }

    public void setFirstGreatestCommonDivisor(int firstGreatestCommonDivisor) {
        this.firstGreatestCommonDivisor = firstGreatestCommonDivisor;
    }

    public List<Integer> getWriteDivision() {
        return writeDivision;
    }

    public void setWriteDivision(List<Integer> writeDivision) {
        this.writeDivision = writeDivision;
    }

    @Override
    public String toString() {
        return "Result{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                ", resultDivision=" + resultDivision +
                ", decomposeDividend=" + decomposeDividend +
                ", amountOfDigitsInFirstPartialDividend=" + amountOfDigitsInFirstPartialDividend +
                ", firstGreatestCommonDivisor=" + firstGreatestCommonDivisor +
                ", writeDivision=" + writeDivision +
                '}';
    }
}


