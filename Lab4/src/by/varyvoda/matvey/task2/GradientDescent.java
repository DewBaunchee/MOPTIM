package by.varyvoda.matvey.task2;

import by.varyvoda.matvey.utils.PrintUtils;

import java.util.Arrays;

public class GradientDescent {

    private static class StepResult {

        public final double result;

        public final double[] newArgs;

        public StepResult(double result, double[] newArgs) {
            this.result = result;
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
        double[] qs = new double[componentCount];
        Arrays.fill(qs, 1);

        int iteration = 1;
        StepResult result = nextStep(qs, iteration++);
        double prevValue = result.result;
        result = nextStep(result.newArgs, iteration++);
        double currentValue = result.result;

        while (Math.abs(prevValue - currentValue) > e) {
            prevValue = currentValue;
            result = nextStep(result.newArgs, iteration++);
            currentValue = result.result;
        }
    }

    private StepResult nextStep(double[] qs, int iteration) {
        double result = function.solve(qs);
        System.out.printf("Iteration #%d: result - %s, qs - %s\n", iteration, result, PrintUtils.formatArray(qs));
        double[] gradient = function.getGradient(qs);
        System.out.printf("Iteration #%d: gradient - %s\n", iteration, PrintUtils.formatArray(gradient));
        qs = add(qs, multiply(-stepLength, gradient));
        System.out.printf("Iteration #%d: new arguments - %s\n\n", iteration, PrintUtils.formatArray(qs));
        return new StepResult(result, qs);
    }

    private static double[] multiply(double multiplier, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] * multiplier;
        }
        return result;
    }

    private static double[] add(double[] left, double[] right) {
        if(left.length != right.length)
            throw new IllegalArgumentException("Length are different.");
        double[] result = new double[left.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }
}
