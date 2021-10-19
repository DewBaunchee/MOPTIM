package by.varyvoda.matvey.task1.utils;

import java.util.Arrays;

public class PrintUtils {

    public static void printResults(double[] args, double[] results, int minIndex) {
        System.out.println("Arguments: " + formatArray(args));
        System.out.println("Results: " + formatArray(results));

        System.out.println("Argument for minimal value: x\u20F0 = " + args[minIndex]);
        System.out.println("Minimal value: f\u20F0 = " + results[minIndex]);
        System.out.println("Region: \u0394 = [" +
                (minIndex < 1
                        ? formatDouble(results[0])
                        : formatDouble(results[minIndex - 1])) + ", " +
                (minIndex > results.length - 2
                        ? formatDouble(results[results.length - 1])
                        : formatDouble(results[minIndex + 1])) + "]"
        );
    }

    public static String formatArray(double[] array) {
        String[] formats = new String[array.length];
        for(int i = 0; i < array.length; i++)
            formats[i] = formatDouble(array[i]);
        return "[" +
                String.join(", ", formats)
                + "]";
    }

    public static String formatDouble(double aDouble) {
        return String.format("%.5f", aDouble);
    }
}