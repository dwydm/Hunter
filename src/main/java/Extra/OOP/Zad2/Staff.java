package Extra.OOP.Zad2;

public class Staff extends Person {
    private String specialization;
    private double salary;

    public Staff(String specialization, double salary) {
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialization field: " + specialization + String.format(", Salary: %.2f PLN", salary);
    }
}
