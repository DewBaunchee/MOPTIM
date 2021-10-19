package by.varyvoda.matvey.task1;

public class Fibonacci extends MinimumSearchTask {

    private int[] F;

    public Fibonacci(int n, double e, double a, double b) {
        super(n, e, a, b);
        calculateSequence(n + 1);
    }

    @Override
    protected double[] generateArguments() {
        int j = 1;
        while (j < n-1) {
            double v = Math.pow(-1, n - j + 1) * e;
            double x1 = a + (b - a) * F[n - j - 1] / F[n - j + 1] - v / F[n - j + 1];
            double x2 = a + (b - a) * F[n - j] / F[n - j + 1] + v / F[n - j + 1];

            if(Function.solve(x1) > Function.solve(x2)) {
                a = x1;
            } else {
                b = x2;
            }
            j++;
        }
        return new double[]{a - e / 2, a, a + e / 2};
    }

    private void calculateSequence(int size) {
        F = new int[size];
        for (int i = 0; i < size; i++) {
            if (i < 2) {
                F[i] = 1;
                continue;
            }
            F[i] = F[i - 2] + F[i - 1];
        }
    }
}
