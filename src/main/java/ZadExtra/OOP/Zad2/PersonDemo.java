package ZadExtra.OOP.Zad2;

public class PersonDemo {
    public static void main(String[] args) {
        Student student = new Student("Economics", "4", 2500);
        student.setName("Albert Nothingfield");
        student.setAdress("Floweryfields 4");

        System.out.println(student);

        Person specialist = new Staff("Robotics", 43_000);

        specialist.setName("Harry");
        specialist.setAdress("Dubois 47");

        System.out.println(specialist);



    }


}
