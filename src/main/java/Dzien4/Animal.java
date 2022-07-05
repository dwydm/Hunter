package Dzien4;

public abstract class Animal {

    private String name;
    private int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void sayHello();

    public void run() {
        System.out.println("Runs!");
    }






}
