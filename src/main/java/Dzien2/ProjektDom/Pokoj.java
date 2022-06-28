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
            return;
        }

        lozko.wymienPosciel();
        sprzatnietyPokoj = true;
    }

    public void otworzOkna() {
        for(Okno okno : okna) {
            okno.otworzOkno();
        }
    }
}
