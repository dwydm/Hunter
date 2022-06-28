package Dzien1.zad2;

import java.util.Random;

public class FabrykaLinii {
    private static int fixedLength = 2;

    public Linia randomLengthLine(String wypenienie) {
        Random rnd = new Random();
        return new Linia(wypenienie, rnd.nextInt(100));
    }

    public Linia randomCharLine(int length) {
        Random rnd = new Random();
        return null;
    }

    public String randomLengthAndChar() {
        Random rnd = new Random();
        return String.valueOf((char)rnd.nextInt(127)).repeat(rnd.nextInt(100));
    }

    public void printLinesOfRandomValue(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println(randomLengthAndChar());
        }
    }

    public void printLineWithFixedLength() {
        System.out.println(randomCharLine(fixedLength));
        fixedLength *= 2;

    }
}
