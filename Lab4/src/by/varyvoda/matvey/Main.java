package by.varyvoda.matvey;

import by.varyvoda.matvey.task1.*;
import by.varyvoda.matvey.task2.Function;
import by.varyvoda.matvey.task2.GradientDescent;

public class Main {

        public static void main(String[] args) {
            System.out.println("**************************************Task 1*****************************************");
            MinimumSearchTask passiveSearchA = new PassiveSearch(16, 0.1, 0, 8);
            passiveSearchA.solve();

            MinimumSearchTask passiveSearchB = new PassiveSearch(17, 0, 0, 8);
            passiveSearchB.solve();

            MinimumSearchTask dichotomy = new Dichotomy(16, 0.1, 0, 8);
            dichotomy.solve();

            MinimumSearchTask fibonacci = new Fibonacci(16, 0.2, 0, 8);
            fibonacci.solve();

            MinimumSearchTask goldenRatio = new GoldenRatio(16, 0, 0, 8);
            goldenRatio.solve();


            System.out.println("**************************************Task 2*****************************************");
            Function function = new Function(
                    new double[]{4000, 2000, 8000, 600, 1500},
                    new double[] {10, 7, 15, 110, 6},
                    new double[] {8, 70, 6, 8, 20}
            );
            GradientDescent gradientDescent = new GradientDescent(1, 5, 0.1, function);
            gradientDescent.solve();
    }
}
