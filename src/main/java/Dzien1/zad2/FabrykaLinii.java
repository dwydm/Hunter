package Dzien1.zad2;

import java.util.Random;

public class FabrykaLinii {
    private static int fixedLength = 1;

    public Linia createLineRandomLength(String wypenienie) {
        Random rnd = new Random();
        return new Linia(wypenienie, (char)rnd.nextInt(100));
    }

    public Linia createLineRandomChar(int length) {
        Random rnd = new Random();
        return new Linia(String.valueOf((char) (rnd.nextInt(94) + 33)), length);
    }

    public Linia createLineRandomCharAndLength() {
        Random rnd = new Random();
        return new Linia(String.valueOf((char) rnd.nextInt(127)), rnd.nextInt(100));
    }

    public Linia[] createArrayOfRandomLines(int numberOfLines) {
        Linia[] linie = new Linia[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            linie[i] = createLineRandomCharAndLength();
        }
        return linie;
    }

    public Linia createLineRandomCharGeometricalLengthIncrease() {
        fixedLength *= 2;
        return createLineRandomChar(fixedLength);

    }
}
