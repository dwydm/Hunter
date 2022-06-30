package Dzien2.ProjektDom;

import java.util.Arrays;

public class Dom {
    private Pokoj[] pokoje;

    public Dom(Pokoj...pokoje) {
        this.pokoje = pokoje;
    }

    public Pokoj getPokoj(int numerPokoju) {
        if(numerPokoju >= pokoje.length || numerPokoju < 0) {
            System.out.println("Nie ma takiego pokoju");
            return null;
        } else {
            return pokoje[numerPokoju];

        }
    }

    @Override
    public String toString() {

        return Arrays.toString(pokoje);
    }
}
