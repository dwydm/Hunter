package Dzien2.ProjektDom;

public class Okno {

    private StanOkna stanOkna = StanOkna.ZAMKNIETE;



    public void otworzOkno(){
        if(stanOkna.czyOtwarte) {
            System.out.println("Okno jest już otwarte");
        } else {
            stanOkna = StanOkna.OTWARTE;
        }
    }

    public void zamknijOnko() {
        if(!stanOkna.czyOtwarte) {
            System.out.println("Bardziej się nie zamknie");
        } else {
            stanOkna = StanOkna.ZAMKNIETE;
        }
    }

    @Override
    public String toString() {
        return "Status okna: " + stanOkna;
    }
}
