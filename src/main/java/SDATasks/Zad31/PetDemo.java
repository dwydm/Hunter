package SDATasks.Zad31;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class PetDemo {
    public static void main(String[] args) {

        //Task setup
        Person john = new Person("John", LocalDate.of(1990, Month.JANUARY,01));
        Person anna = new Person("Anna", LocalDate.of(1997,Month.APRIL,04));
        Person kamila = new Person("Kamila", LocalDate.of(2000,Month.JUNE,02));

        john.getPets().add(new Pet("Tom",6));
        john.getPets().add(new Pet("Jerry", 3));
        john.getPets().add(new Pet("Butcher", 6));

        anna.getPets().add(new Pet("Ara",2));
        anna.getPets().add(new Pet("Cookie",4));

        List<Person> people = new ArrayList<>(Arrays.asList(john,kamila,anna));


        //a
        people.stream().map((person) -> person.getName())
                .sorted(Comparator.naturalOrder())
                .toList()
                .forEach(name -> System.out.println(name));

        //b
        people.stream().map(person -> person.getBirthDay().getMonth().getValue())
                .toList()
                .forEach(month -> System.out.println(month));





    }
}
