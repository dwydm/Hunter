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
        int result = Arrays.stream(numbers)
                .distinct()
                .sum();

        return result;
    }

    @Override
    public List<String> computeMaleNames(List<String> names) {
        List<String> femaleNames = names.stream()
                .filter((name) -> name.endsWith("a"))
                .collect(Collectors.toList());
        return femaleNames;
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
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        return nameLengths;
    }

    @Override
    public List<Person> buildPeopleWithNames(List<String> names) {
        return null;
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
