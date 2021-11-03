package by.varyvoda.matvey.task2;

import by.varyvoda.matvey.utils.PrintUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradientDescent extends Thread {

    private static class StepResult {

        public final double result;

        public final double[] args;

        public final double[] newArgs;

        public StepResult(double result, double[] args, double[] newArgs) {
            this.result = result;
            this.args = args;
            this.newArgs = newArgs;
        }
    }

    private final double stepLength;
    private final int componentCount;
    private final double e;
    private final Function function;

    public GradientDescent(double stepLength, int componentCount, double e, Function function) {
        this.stepLength = stepLength;
        this.componentCount = componentCount;
        this.e = e;
        this.function = function;
    }

    public void solve() {
        start();
    }

    public void run() {
        List<String> minimums = new ArrayList<>();
        double[] qs = new double[componentCount];
        Arrays.fill(qs, 1);

        boolean isDescending = true;
        int iteration = 1;

        StepResult result = nextStep(qs, makeSender(minimums, iteration++));
        double prevValue = result.result;
        result = nextStep(result.newArgs, makeSender(minimums, iteration++));
        double currentValue = result.result;

        while (!isInterrupted()) {
            if (Math.abs(prevValue - currentValue) < e) {
                minimums.add(currentValue + " at " + PrintUtils.formatArray(result.args));
                break;
            } else if (isDescending && prevValue < currentValue) {
                minimums.add(currentValue + " at " + PrintUtils.formatArray(result.args));
            }

            isDescending = currentValue < prevValue;

            prevValue = currentValue;
            result = nextStep(result.newArgs, makeSender(minimums, iteration++));
            currentValue = result.result;
        }

        if (minimums.isEmpty())
            System.out.println("No minimums found.");
        else
            System.out.println(minimums.stream().reduce("", (accumulator, value) -> accumulator + "\n" + value));

    }

    private String makeSender(List<String> minimums, int iteration) {
        return String.format("[%d min%s] - Iteration: %d: ", minimums.size(), minimums.size() == 1 ? "" : "s", iteration);
    }

    private StepResult nextStep(double[] qs, String sender) {
        double result = function.solve(qs);
        System.out.printf("%s: result - %s, qs - %s\n", sender, result, PrintUtils.formatArray(qs));
        double[] gradient = function.getGradient(qs);
        System.out.printf("%s: gradient - %s\n", sender, PrintUtils.formatArray(gradient));
        double[] oldQs = qs;
        qs = add(qs, multiply(-stepLength, gradient));
        System.out.printf("%s: new arguments - %s\n\n", sender, PrintUtils.formatArray(qs));
        return new StepResult(result, oldQs, qs);
    }

    public void waitForSolving() {
        try {
            System.in.read();
        } catch (IOException ignored) {

        }
        if (isAlive()) {
            interrupt();
            try {
                join();
            } catch (InterruptedException ignored) {

            }
        }
    }

    private static double[] multiply(double multiplier, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] * multiplier;
        }
        return result;
    }

    private static double[] add(double[] left, double[] right) {
        if (left.length != right.length)
            throw new IllegalArgumentException("Length are different.");
        double[] result = new double[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }
}
