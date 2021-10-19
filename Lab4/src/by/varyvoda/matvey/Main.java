package by.varyvoda.matvey;

import by.varyvoda.matvey.task1.Dichotomy;
import by.varyvoda.matvey.task1.MinimumSearchTask;
import by.varyvoda.matvey.task1.PassiveSearch;

public class Main {

        public static void main(String[] args) {
            MinimumSearchTask passiveSearchA = new PassiveSearch(16, 0.1, 0, 8);
            passiveSearchA.solve();

            MinimumSearchTask passiveSearchB = new PassiveSearch(17, 0, 0, 8);
            passiveSearchB.solve();

            MinimumSearchTask dichotomy = new Dichotomy(16, 0.1, 0, 8);
            dichotomy.solve();
    }
}
