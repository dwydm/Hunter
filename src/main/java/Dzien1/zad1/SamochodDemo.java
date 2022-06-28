package Dzien1.zad1;

public class SamochodDemo {
    public static void main(String[] args) {

        Samochod[] samochody = {new Samochod("Toyota", 67000),
                                new Samochod("Honda", 17000),
                                new Samochod("BMW", 11000),
                                new Samochod("Audi", 43000)};


        for(Samochod auto : samochody) {
            System.out.println(auto);
        }

    }
}
