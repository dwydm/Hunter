package ZadDom.Workshop;

public class Wheel {
    private double pressure;
    private boolean isDamaged;

    public Wheel(double pressure) {
        this.pressure = pressure;
    }

    public Wheel(double pressure, boolean isDamaged) {
        this.pressure = pressure;
        this.isDamaged = isDamaged;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }


    public void setTireCondition(boolean isDamaged) {
        this.isDamaged = isDamaged;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void damageTire() {
        pressure = 0.5;
        isDamaged = true;
    }

    @Override
    public String toString() {
        return isDamaged ? "Wheel status: Damaged | Pressure: " + pressure : "Wheel status: OK | Pressure: " + pressure;
    }
}
