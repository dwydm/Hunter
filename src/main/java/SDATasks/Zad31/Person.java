package SDATasks.Zad31;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private LocalDate birthDay;
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
