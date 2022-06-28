package Dzien1.zad1;

import java.util.Random;

public class Samochod {

    private String marka;
    private int przebieg;
    private int przebiegDoPrzegladu = 20_000;



    public Samochod (String marka, int przebieg) {
        this.marka = marka;
        this.przebieg = przebieg;
        if(przebieg > przebiegDoPrzegladu) {
            Random rnd = new Random();

            przebiegDoPrzegladu = przebieg + rnd.nextInt(15000);
        }
    }


    @Override
    public String toString() {
        return marka + " \nPrzebieg: " + przebieg + "\nNastępny przegląd za: " + (przebiegDoPrzegladu - przebieg);
    }

}
