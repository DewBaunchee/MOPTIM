package by.varyvoda.matvey;

import by.varyvoda.matvey.task1.*;

public class FirstTask {

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
    }
}
