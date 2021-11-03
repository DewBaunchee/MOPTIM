package by.varyvoda.matvey.task2;

public class Function {

    private final double[] vs;
    private final double[] Ks;
    private final double[] s;

    public Function(double[] vs, double[] Ks, double[] s) {
        this.vs = vs;
        this.Ks = Ks;
        this.s = s;
    }

    /*
    (Ks[0] * vs[0] / q1 + 0.5 * s[0] * q1) +
    (Ks[1] * vs[1] / q2 + 0.5 * s[1] * q2) +
    (Ks[2] * vs[2] / q3 + 0.5 * s[2] * q3) +
    (Ks[3] * vs[3] / q4 + 0.5 * s[3] * q4) +
    (Ks[4] * vs[4] / q5 + 0.5 * s[4] * q5);
    */

    private double solveComponent(double q, int index) {
        return Ks[index] * vs[index] / q + 0.5 * s[index] * q;
    }

    public double solve(double... qs) {
        double result = 0;
        for (int i = 0; i < qs.length; i++) {
            result += solveComponent(qs[i], i);
        }
        return result;
    }

    private double solveDerivativeComponent(double q, int index) {
        return -2 * Ks[index] * vs[index] / (q * q) + 0.5 * s[index];
    }

    public double[] getGradient(double... qs) {
        double[] gradient = new double[qs.length];
        for (int i = 0; i < qs.length; i++) {
            gradient[i] = solveDerivativeComponent(qs[i], i);
        }
        return gradient;
    }
}
