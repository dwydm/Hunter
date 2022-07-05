package Extra.OOP.Highway;

import java.util.Date;
import java.util.HashMap;

public class Highway {
    public static HashMap<String,VehicleInfo> vehiclesOnHighway = new HashMap<>();


    public void vehicleEntry(String licencePlate, CarType carType) {
        if(!vehiclesOnHighway.containsKey(licencePlate)) {
            vehiclesOnHighway.put(licencePlate,new VehicleInfo(licencePlate,carType));
            System.out.println("Vehicle " + licencePlate + " entered the highway\n");
        }
        else {
            System.out.println("Vehicle " + licencePlate + " is already on the highway");
        }
    }

    public void searchVehicle(String licencePlate) {
        if(!vehiclesOnHighway.containsKey(licencePlate)) {
            System.out.println("Unable to find vehicle " + licencePlate + " on the highway");
            return;
        }
        VehicleInfo vehicle = vehiclesOnHighway.get(licencePlate);
        System.out.println("Licence plate " + vehicle.getLicencePlate() + ", vehicle type " + vehicle.getVehicleType() + ", time of entrance " + vehicle.getTimeOfEntrance());

    }

    public void vehicleLeave(String licencePlate) {
        if (!vehiclesOnHighway.containsKey(licencePlate)) {
            System.out.println("Unable to find vehicle " + licencePlate + " on the highway");
            return;
        }

        VehicleInfo vehicle = vehiclesOnHighway.get(licencePlate);

            Date timeOfExit = new Date();
            int secondsOnTheHighway = (int) (timeOfExit.getTime() - vehicle.getTimeOfEntrance().getTime()) / 1000;

            double highwayFare = secondsOnTheHighway * vehicle.getVehicleType().highwayFare;

            System.out.printf("For vehicle " + licencePlate + ", type: " + vehicle.getVehicleType() + ", highway fare is: %.2f PLN\n", highwayFare);
            vehiclesOnHighway.remove(licencePlate);


    }

}
