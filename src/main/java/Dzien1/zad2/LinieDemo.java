package Dzien1.zad2;

public class LinieDemo {
    public static void main(String[] args) {
        FabrykaLinii fabrl = new FabrykaLinii();

        System.out.println("\nrandomLengthLine");
        System.out.println(fabrl.randomLengthLine("7"));
        System.out.println("\nrandomCharLine");
        System.out.println(fabrl.randomCharLine(30));
        System.out.println("\nrandomLengthAndChar");
        System.out.println(fabrl.randomLengthAndChar());
        System.out.println("\nprintLinesOfRandomValue");
        fabrl.printLinesOfRandomValue(4);
        System.out.println("\nprintLineWithFixedLength");

        fabrl.printLineWithFixedLength();
        fabrl.printLineWithFixedLength();
        fabrl.printLineWithFixedLength();
        fabrl.printLineWithFixedLength();
        fabrl.printLineWithFixedLength();

    }
}
