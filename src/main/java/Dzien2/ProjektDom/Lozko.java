package Dzien2.ProjektDom;

public class Lozko {
    private int dniOdOstatniejZmianyPoscieli;


    public int getDniOdOstatniejZmianyPoscieli() {
        return dniOdOstatniejZmianyPoscieli;
    }

    public Lozko(int dniOdOstatniejZmianyPoscieli) {
        this.dniOdOstatniejZmianyPoscieli = dniOdOstatniejZmianyPoscieli;
    }

    public void wymienPosciel() {
        this.dniOdOstatniejZmianyPoscieli = 0;
    }


    @Override
    public String toString() {
        return "Ostatnio zmieniana pościel: " + dniOdOstatniejZmianyPoscieli;
    }
}
