package ZadExtra.OOP.Highway;

public enum CarType {
    TRUCK(0.025),
    CAR(0.014),
    MOTORCYCLE(0.008);

    final double highwayFare;

    CarType(double highwayFare) {
        this.highwayFare = highwayFare;
    }
}
