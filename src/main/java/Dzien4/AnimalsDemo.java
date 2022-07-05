package Dzien4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalsDemo {


    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>(Arrays.asList(new Rooster("Clemens", 4, "Sharp!"),
                                                                new Horse("Henry", 6, "Black"),
                                                                new Cow("Vivien", 3, true)));

        for(Animal animal : animalList) {
            System.out.println("I am " + animal.getClass().getSimpleName());
            animal.sayHello();
        }


    }
}
