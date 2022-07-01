package ZadDom.Workshop;

import java.util.Arrays;
import java.util.Random;

public class Car {
    private Wheel[] wheels;

    public Car(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void flatTireEncounter() {
        Random rnd = new Random();
        int flattenTires = rnd.nextInt(5)+1;

        while (flattenTires > 0) {
            if (wheels[rnd.nextInt(wheels.length)].isDamaged()) {
                continue;
            } else {
                wheels[rnd.nextInt(wheels.length)].damageTire();
                flattenTires--;
            }
        }
        try {
            System.out.println("Riding until car tire is broken");
            for (int i = 0; i < 8; i++) {
                System.out.print(".");
                Thread.sleep(700);
            }
            System.out.println(" *poof*\nYour car was successfully damaged");
        } catch (InterruptedException e) {
            System.out.println("Tire punctured on purpose");
        }

    }

    @Override
    public String toString() {
        return "Car status: \n" + "Wheels: " + Arrays.toString(wheels);
    }
}
