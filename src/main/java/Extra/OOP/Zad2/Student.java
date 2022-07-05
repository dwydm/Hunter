package Extra.OOP.Zad2;

public class Student extends Person {
    private String fieldOfStudy;
    private String academicYear;
    private Double payment;

    public Student (String fieldOfStudy, String academicYear, double payment) {
        this.fieldOfStudy = fieldOfStudy;
        this.academicYear = academicYear;
        this.payment = payment;

    }


    @Override
    public String toString() {
        return super.toString() + "\nField of study: " + fieldOfStudy + ", Academic year: " + academicYear + String.format(", Payment: %.2f PLN", payment);
    }
}
