package by.varyvoda.matvey.utils;

public class PrintUtils {

    public static void printResults(double[] args, double[] results, int minIndex) {
        System.out.println("Arguments: " + formatArray(args));
        System.out.println("Results: " + formatArray(results));

        System.out.println("Argument for minimal value: x\u20F0 = " + formatDouble(args[minIndex]));
        System.out.println("Minimal value: f\u20F0 = " + formatDouble(results[minIndex]));
        System.out.println("Region: \u0394 = [" +
                (minIndex < 1
                        ? formatDouble(args[0])
                        : formatDouble(args[minIndex - 1])) + ", " +
                (minIndex > args.length - 2
                        ? formatDouble(args[args.length - 1])
                        : formatDouble(args[minIndex + 1])) + "]"
        );
    }

    public static String formatArray(double[] array) {
        String[] formats = new String[array.length];
        for(int i = 0; i < array.length; i++)
            formats[i] = formatDouble(array[i]);
        return "[" +
                String.join("; ", formats)
                + "]";
    }

    public static String formatDouble(double aDouble) {
        return String.format("%.5f", aDouble);
    }
}
