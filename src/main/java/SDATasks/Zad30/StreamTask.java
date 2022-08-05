package SDATasks.Zad30;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class StreamTask {
    private static List<Integer> integers = new ArrayList<>();

    static {
        fillListWithNumbers();
    }

    public static void main(String[] args) {

        //a
        integers.forEach(integer -> System.out.println(integer));

        //b
        integers = integers.stream().sorted((integerA, integerB) -> integerA - integerB ).toList();

        //c
        System.out.println(integers.stream().filter((integerA) -> integerA % 2 == 0).count());


    }

    private static void fillListWithNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            integers.add(rnd.nextInt(101));
        }
    }

}
