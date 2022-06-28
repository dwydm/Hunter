package Dzien2.ProjektDom;

public class Pokoj {
    private Okno[] okna;
    private Lozko lozko;

    private boolean sprzatnietyPokoj;

    public Pokoj() {

    }

    public Pokoj(Lozko lozko, int liczbaOkien) {
        this.lozko = lozko;
        okna = new Okno[liczbaOkien];
        for (int i = 0; i < liczbaOkien; i++) {
            okna[i] = new Okno();
        }
    }

    public void posprzataj() {
        if(lozko == null) {
            System.out.println("Nie ma co sprzątać");
            return;
        }

        lozko.wymienPosciel();
        otworzOkna();
        sprzatnietyPokoj = true;
    }

    public void otworzOkna() {
        for(Okno okno : okna) {
            okno.otworzOkno();
        }
    }


    @Override
    public String toString() {
        if(lozko == null || okna == null) {
            return "Ten pokoj jest pusty";
        }

        return sprzatnietyPokoj ? "Posprzątane, łóżko ścielone " + lozko.getDniOdOstatniejZmianyPoscieli() + " dni temu. W pokoju są " + okna.length + " okna" :
                                    "Nie jest posprzątane, łóżko ścielone " + lozko.getDniOdOstatniejZmianyPoscieli() + " dni temu. W pokoju są " + okna.length + " okna";
    }
}
