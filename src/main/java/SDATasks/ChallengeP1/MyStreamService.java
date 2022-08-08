package SDATasks.ChallengeP1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyStreamService implements StreamService{
    @Override
    public void sortAndPrint(List<String> names) {
        names.stream()
                .sorted()
                .forEach(System.out::println);

    }

    @Override
    public int distinctAndCountNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .sum();
    }

    @Override
    public List<String> computeMaleNames(List<String> names) {
        return names.stream()
                .filter((name) -> name.endsWith("a"))
                .collect(Collectors.toList());
    }

    @Override
    public void printNumbersOfRange(int[] numbers, int minValue, int maxValue) {
        Arrays.stream(numbers)
                .sorted()
                .filter(number -> number <= maxValue && number >= minValue)
                .forEach(System.out::println);

    }

    @Override
    public List<Integer> computeNamesLength(List<String> names) {
        return names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> buildPeopleWithNames(List<String> names) {
        return names.stream()
                .map(name -> new MyPerson(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findPeopleOfIdGreaterThan(List<Person> people, int id) {
        return null;
    }

    @Override
    public boolean hasSenior(List<Person> people) {
        return false;
    }

    @Override
    public double sumTotalCash(List<Person> people) {
        return 0;
    }

    @Override
    public Person findRichestPerson(List<Person> people) {
        return null;
    }

    @Override
    public double computeAverageAge(List<Person> people) {
        return 0;
    }
}
