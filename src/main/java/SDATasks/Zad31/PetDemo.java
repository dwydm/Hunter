package SDATasks.Zad31;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class PetDemo {
    public static void main(String[] args) {

        //Task setup
        Person john = new Person("John", LocalDate.of(1990, Month.JANUARY, 01));
        Person anna = new Person("Anna", LocalDate.of(1997, Month.APRIL, 04));
        Person kamila = new Person("Kamila", LocalDate.of(2000, Month.JUNE, 02));

        john.getPets().add(new Pet("Tom", 6));
        john.getPets().add(new Pet("Jerry", 3));
        john.getPets().add(new Pet("Butcher", 6));

        anna.getPets().add(new Pet("Ara", 2));
        anna.getPets().add(new Pet("Cookie", 4));

        List<Person> people = new ArrayList<>(Arrays.asList(john, kamila, anna));


        //a
        people.stream().map((person) -> person.getName())
                .sorted(Comparator.naturalOrder())
                .toList()
                .forEach(name -> out.println(name));

        //b
        people.stream().map(person -> person.getBirthDay().getMonth().getValue())
                .toList()
                .forEach(out::println);

        //c
        people.stream().flatMap(person -> Stream.of(person.getPets().size())).forEach(out::println);

        //d
        out.println("Total animal age: " + people.stream()
                .map(Person::getPets)
                .flatMap(petList -> petList.stream())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Pet::getAge)
                .sum());

        //f
        out.println("Average owner age: " +people.stream()
                .mapToInt(Person::getAge)
                .sum() / people.stream()
                .count());
    }

}
