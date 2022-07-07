package SDAKurs.Dzien2.ProjektDom;

public enum StanOkna {
    ZAMKNIETE(false),
    OTWARTE(true);

    final boolean czyOtwarte;

    StanOkna(boolean czyOtwarte) {
        this.czyOtwarte = czyOtwarte;
    }
}
