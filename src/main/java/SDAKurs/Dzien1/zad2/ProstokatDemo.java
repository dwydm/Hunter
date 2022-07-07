package SDAKurs.Dzien1.zad2;

public class ProstokatDemo {
    public static void main(String[] args) {

        Prostokat p1 = new Prostokat(4,3,"^");
        Prostokat p2 = new Prostokat(7,7,"%");

        p1.printSquare();
        System.out.println();
        p2.printSquare();
        System.out.println("linie");
        Linia l1 = new Linia("#",5);
        l1.drukujLinie();

    }


}
