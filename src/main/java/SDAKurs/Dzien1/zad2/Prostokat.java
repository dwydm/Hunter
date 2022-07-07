package SDAKurs.Dzien1.zad2;

public class Prostokat {
    private int wysokosc;
    private int szerokosc;
    private String wypelnienie;


    public Prostokat(int wysokosc, int szerokosc, String wypelnienie) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.wypelnienie = wypelnienie;
    }


    public void printSquare() {

        for (int i = 0; i < wysokosc; i++) {
            System.out.print(wypelnienie.repeat(szerokosc) + "\n");
        }

    }

    @Override
    public String toString() {
        return "Wysokość: " + wysokosc + ", Szerokość: " + szerokosc + ", Wypełnienie: " + wypelnienie;
    }
}
