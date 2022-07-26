package SDAKurs.Dzien9;

import java.util.ArrayList;

public class SortingAlgorithm {


    public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        int min;
        int index;

        for (int i = 0; i < list.size(); i++) {
            min = list.get(i);
            index = i;
            for (int j = i; j < list.size(); j++) {
                if(min > list.get(j)) {
                    min = list.get(j);
                    index = j;
                }
            }
            if (index == i) {
                continue;
            }
            list.set(index, list.get(i));
            list.set(i,min);

        }

        return list;
    }

}
