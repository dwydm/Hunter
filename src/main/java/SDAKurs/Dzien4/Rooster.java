package SDAKurs.Dzien4;

public class Rooster extends  Animal{
    private String claws;

    public Rooster(String name, int age, String claws) {
        super(name, age);
        this.claws = claws;
    }

    @Override
    public void sayHello(){
        System.out.println("Kukurykuuuuuuu!");
    }


}
