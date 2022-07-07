package SDAKurs.Dzien4;

public class Cow extends Animal{
    private boolean hasHorns;

    public Cow(String name, int age, boolean hasHorns) {
        super(name, age);
        this.hasHorns = hasHorns;
    }

    @Override
    public void sayHello() {
        System.out.println("Mooooo!");
    }
}
