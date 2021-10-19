package by.varyvoda.matvey.task1;

public class Dichotomy extends MinimumSearchTask {

    public Dichotomy(int n, double e, double a, double b) {
        super(n, e, a, b);
    }

    protected double[] generateArguments() {
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            int ordinal = i + 1;
            if (ordinal % 2 == 0) {
                x[i] = a + ordinal * (b - a) / (0.5 + 1) + 0.5 * e;
            } else {
                x[i] = a + ordinal * (b - a) / (0.5 + 1) - 0.5 * e;
            }
        }
        return x;
    }
}
