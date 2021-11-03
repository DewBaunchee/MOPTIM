package by.varyvoda.matvey;

import by.varyvoda.matvey.task2.Function;
import by.varyvoda.matvey.task2.GradientDescent;

public class SecondTask {

    public static void main(String[] args) {
        System.out.println("**************************************Task 2*****************************************");
        Function function = new Function(
                new double[]{4000, 2000, 8000, 600, 1500},
                new double[] {10, 7, 15, 110, 6},
                new double[] {8, 70, 6, 8, 20}
        );
        GradientDescent gradientDescent = new GradientDescent(0.0001, 5, 0.0000001, function);
        gradientDescent.solve();
        gradientDescent.waitForSolving();


//        Function function1 = new Function(
//                new double[]{4000},
//                new double[] {10},
//                new double[] {8}
//        );
//        GradientDescent gradientDescent1 = new GradientDescent(0.0001, 1, 0.00000000001, function1);
//        gradientDescent1.solve();
//        gradientDescent1.waitForSolving();
    }
}
