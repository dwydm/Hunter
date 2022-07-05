package Dzien4;

public class Horse extends Animal{

    private String bristles;


    public Horse(String name, int age, String bristles) {
        super(name, age);
        this.bristles = bristles;
    }


    @Override
    public void sayHello(){
        System.out.println("Ihaaaaaa");
    }
}
