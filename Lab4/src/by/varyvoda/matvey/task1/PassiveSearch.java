package by.varyvoda.matvey.task1;

public class PassiveSearch extends MinimumSearchTask {

    public PassiveSearch(int n, double e, double a, double b) {
        super(n, e, a, b);
    }

    protected  double[] generateArguments() {
        if (n % 2 == 1) {
            return generateOdd();
        } else {
            return generateEven();
        }
    }

    private double[] generateOdd() {
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = a + (i + 1) * (b - a) / (n + 1);
        }
        return x;
    }

    private double[] generateEven() {
        double[] x = new double[n];
        for (int i = 0; i < n / 2; i++) {
            final double v = (i + 1) * (b - a) / (0.5 * n + 1);
            x[2 * i] = a + v - 0.5 * e;
            x[2 * i + 1] = a + v + 0.5 * e;
        }
        return x;
    }
}
