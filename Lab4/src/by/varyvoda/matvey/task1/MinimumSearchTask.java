package by.varyvoda.matvey.task1;

import by.varyvoda.matvey.task1.utils.PrintUtils;

import java.util.Arrays;

public abstract class MinimumSearchTask {

    protected final int n;
    protected final double e;
    protected final double a;
    protected final double b;

    public MinimumSearchTask(int n, double e, double a, double b) {
        this.n = n;
        this.e = e;
        this.a = a;
        this.b = b;
    }

    protected abstract double[] generateArguments();

    public void solve() {
        double[] args = generateArguments();
        double[] results = Arrays.stream(args).map(Function::solve).toArray();
        int minIndex = findMinIndex(results);

        System.out.printf("Search by %s, n = %s%s:\n", getClass().getSimpleName(), n, (n % 2 == 0 ? ", e = " + e : ""));
        PrintUtils.printResults(args, results, minIndex);
        System.out.println();
    }

    private int findMinIndex(double[] array) {
        if (array.length == 0)
            return -1;

        double min = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
