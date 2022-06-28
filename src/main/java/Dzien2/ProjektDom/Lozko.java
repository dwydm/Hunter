package Dzien2.ProjektDom;

public class Lozko {
    private int dniOdOstatniejZmianyPoscieli;

    public Lozko(int dniOdOstatniejZmianyPoscieli) {
        this.dniOdOstatniejZmianyPoscieli = dniOdOstatniejZmianyPoscieli;
    }

    public void wymienPosciel() {
        System.out.println("Posciel wymieniona");
        this.dniOdOstatniejZmianyPoscieli = 0;
    }
}
