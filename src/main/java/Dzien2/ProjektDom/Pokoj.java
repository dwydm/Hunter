package Dzien2.ProjektDom;

public class Pokoj {
    private Okno[] okna;
    private Lozko lozko;

    private boolean sprzatnietyPokoj;

    public Pokoj() {
        this.lozko = new Lozko(5);
        this.okna = new Okno[] {new Okno(), new Okno()};

    }

    public Pokoj(Lozko lozko, int liczbaOkien) {
        this.lozko = lozko;

        okna = new Okno[liczbaOkien];
        for (int i = 0; i < liczbaOkien; i++) {
            okna[i] = new Okno();
        }
        if (lozko.getDniOdOstatniejZmianyPoscieli() == 0) {
            sprzatnietyPokoj = true;
        }
    }

    public void posprzataj() {
        lozko.wymienPosciel();
        otworzOkna();
        sprzatnietyPokoj = true;
    }

    public void otworzOkna() {
        for (Okno okno : okna) {
            okno.otworzOkno();
        }
    }

    public Okno[] getOkna() {
        return okna;
    }


    @Override
    public String toString() {

        return sprzatnietyPokoj ? "Posprzatane, posciel wymieniana " + lozko.getDniOdOstatniejZmianyPoscieli() + " dni temu. W pokoju znajduja sie " + okna.length + " okna" :
                "Nie jest posprzatane, posciel wymieniana " + lozko.getDniOdOstatniejZmianyPoscieli() + " dni temu. W pokoju znajduja sie " + okna.length + " okna";
    }
}
