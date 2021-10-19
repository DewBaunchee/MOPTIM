package by.varyvoda.matvey.task1;

public class Dichotomy extends MinimumSearchTask {

    public Dichotomy(int n, double e, double a, double b) {
        super(n, e, a, b);
    }

    protected double[] generateArguments() {
        int j = 1;
        while (j < n / 2 && b - a > e) {
            double x1 = (a + b) / 2 - e / 2;
            double x2 = (a + b) / 2 + e / 2;

            if (Function.solve(x1) > Function.solve(x2)) {
                a = x1;
            } else {
                b = x2;
            }
            j++;
        }
        double result = (a + b) / 2;
        return new double[]{result - e / 2, result, result + e / 2};
    }
}
