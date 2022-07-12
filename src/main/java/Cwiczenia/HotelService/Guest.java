package Cwiczenia.HotelService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "Name: " + name + " Surname: " + surname + " DoB: " + dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
