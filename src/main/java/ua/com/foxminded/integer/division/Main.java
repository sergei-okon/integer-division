package ua.com.foxminded.integer.division;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IntegerDivision integerDivision = new IntegerDivision();
        int dividend;
        int divisor;

        try {
            System.out.println("Input dividend");
            dividend = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("You entered incorrect dividend values");
        }

        try {
            System.out.println("Input divisor");
            divisor = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("You entered incorrect divisor values");
        }
        scanner.close();
        System.out.println(integerDivision.makeDivision(dividend, divisor));
    }
}


