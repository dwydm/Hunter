package Dzien2.ProjektDom;

public class Okno {

    private boolean otwarteOkno;



    public void otworzOkno(){
        if(otwarteOkno) {
            System.out.println("Okno jest już otwarte");
        } else {
            otwarteOkno = true;
        }
    }

    public void zamknijOnko() {
        if(!otwarteOkno) {
            System.out.println("Bardziej się nie zamknie");
        } else {
            otwarteOkno = false;
        }
    }

    @Override
    public String toString() {
        return "Status okna: " + otwarteOkno;
    }
}
