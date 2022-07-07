package Cwiczenia.Highway;

import java.util.Date;

public class VehicleInfo {

    private String licencePlate;

    private CarType vehicleType;

    private Date timeOfEntrance;


    public VehicleInfo (String licencePlate, CarType vehicleType) {
        this.licencePlate = licencePlate;
        this.vehicleType = vehicleType;
        this.timeOfEntrance = new Date();
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public CarType getVehicleType() {
        return vehicleType;
    }

    public Date getTimeOfEntrance() {
        return timeOfEntrance;
    }

}
