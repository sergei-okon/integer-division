package ua.com.foxminded.division;

import ua.com.foxminded.division.exception.BadArgsException;
import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.model.Result;
import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;

public class Main {

    public static void main(String[] args) throws BadArgsException {
        if (args.length != 2) {
            System.out.print("Error: Wrong number of arguments entered");
            System.exit(1);
        }
        try {
            int dividend = Integer.parseInt(args[0]);
            int divisor = Integer.parseInt(args[1]);

            Divider divider = new Divider();

            Result result = divider.divide(dividend, divisor);

            Formatter formatter = new ClassicFormatter();
            StringBuilder output = formatter.format(result);
            System.out.print(output);

        } catch (Exception ignored) {
            throw new BadArgsException("Error: Invalid arguments entered");
        }
    }
}

