package by.varyvoda.matvey.task1;

public class GoldenRatio extends MinimumSearchTask {

    private static final double F = (1 + Math.sqrt(5)) / 2;

    public GoldenRatio(int n, double e, double a, double b) {
        super(n, e, a, b);
    }

    @Override
    protected double[] generateArguments() {
        int j = 1;
        double x1 = 0, x2 = 0;
        while (j < n && b - a > e) {
            x1 = b - (b - a) / F;
            x2 = a + (b - a) / F;

            if (Function.solve(x1) > Function.solve(x2)) {
                a = x1;
            } else {
                b = x2;
            }
            j++;
        }
        return new double[]{a, x1, x2, b};
    }
}
