package ZadDom.Workshop;

public class WorkshopDemo {

    public static void main(String[] args) {
        Wheel[] wheels = new Wheel[]{new Wheel(2.85), new Wheel(2.84), new Wheel(3.19), new Wheel(3.22)};

        Car someCar = new Car(wheels);
        someCar.flatTireEncounter();

        System.out.println(someCar);

        Workshop workshop = new Workshop();

        System.out.println(workshop.wheelRepairService(someCar));

        System.out.println(someCar);
    }
}
