package Dzien1.zad2;

import java.util.Arrays;

public class LinieDemo {
    public static void main(String[] args) {
        FabrykaLinii fabrl = new FabrykaLinii();

        System.out.println("\nrandomLengthLine");
        System.out.println(fabrl.createLineRandomLength("?"));
        System.out.println("\nrandomCharLine");
        System.out.println(fabrl.createLineRandomChar(30));
        System.out.println("\nrandomLengthAndChar");
        System.out.println(fabrl.createLineRandomCharAndLength());
        System.out.println("\nprintLinesOfRandomValue");
        System.out.println(Arrays.toString(fabrl.createArrayOfRandomLines(4)));
        System.out.println("\nprintLineWithFixedLength");
        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());

        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());
        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());
        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());
        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());
        System.out.println(fabrl.createLineRandomCharGeometricalLengthIncrease());

    }
}
