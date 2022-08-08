package SDATasks.Zad30;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamTask {
    private static List<Integer> integers = new ArrayList<>();

    static {
        fillListWithNumbers();
    }

    public static void main(String[] args) {

        //a
        integers.forEach(integer -> System.out.println(integer));

        //b
        integers.stream()
                .sorted()
                .forEach(integer -> System.out.println("Sorted: " + integer));

        //c
        System.out.println("Odd num: " + integers.stream().filter((integerA) -> integerA % 2 == 0).count());

        //d
        List<Integer> newIntegers = integers.stream()
                .filter(integer -> integer <= 50)
                .collect(Collectors.toList());

        System.out.println(newIntegers);

        //
        System.out.println(integers.stream()
                .sorted((num1, num2) -> num2 - num1)
                .findFirst()
                .get());


    }

    private static void fillListWithNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            integers.add(rnd.nextInt(101));
        }
    }

}
