package SDAKurs.Dzien9.Sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(-1,0,5,40,33,21,50,7,64,33,24,55,64,-2));

        SortingAlgorithm sort = new SortingAlgorithm();

        System.out.println(sort.selectionSort((ArrayList<Integer>) list));

    }
}
