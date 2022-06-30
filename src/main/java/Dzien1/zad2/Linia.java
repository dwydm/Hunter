package Dzien1.zad2;

public class Linia {
    private String wypelnienie;
    private int dlugosc;

    public Linia(String wypelnienie, int dlugosc) {
        this.wypelnienie = wypelnienie;
        this.dlugosc = dlugosc;
    }

    public void drukujLinie(){
        System.out.println(wypelnienie.repeat(dlugosc));
    }

    @Override
    public String toString() {
        return "Wypelnienie: " + "'" + wypelnienie + "'" + " | Dlugosc: " + dlugosc + "\n";
    }
}
