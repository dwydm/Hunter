package SDATasks.recap1;

import SDATasks.recap1.GroceryShop.Basket;
import SDATasks.recap1.GroceryShop.OrderService;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecapOne {
    private static Scanner scn = new Scanner(System.in);
    private static List<Employee> employees;
    static {
        employees = new ArrayList<>(List.of(
                new Employee(0,"Evan","Martin", 12000),
                new Employee(1,"Anna", "Dim", 9000),
                new Employee(2, "Samuel", "Green", 22000),
                new Employee(3, "Marta", "Stark", 32000),
                new Employee(4, "Simon", "Bird", 42000)
        ));

    }

    public static void main(String[] args) {

        //reverseNumberWithWhileLoop();                                                              //task 1
        //createAndBubbleSortArray();                                                                //task 2
        //calculateAverageFromListWithStreams(Arrays.asList(7,3,5,10));                              //task 3
        //convertAllStringsToUpperCaseWithStreams(Arrays.asList("strEams","Names", "dogs"));         //taks 4
        //filterThreeLetterStringsWithStreams(List.of("ada", "armor", "Ala", "mak"));                //taks 5
        //changeAndDisplayListOfNumbersWithStreams(List.of(4,2,1,7,9,2,10));                         //task 6
        //findEmployeeWithStreams();                                                                 //task 7
        //sortEmployeeList();                                                                        //task 8
        //findTopSalary();                                                                           //task 9
        Basket basket = new Basket();                                                       // Task 10,11,12
        basket.checkPrice();
        basket.addNewProduct(11.11, LocalDate.of(2022,9,1), 300);
        basket.displayAvailability();
        basket.decreaseProductCount(5,201);
        basket.displayProductCount();

        OrderService orderService = new OrderService();
        orderService.sumBasketValue(basket);




    }

    private static void reverseNumberWithWhileLoop() {
        System.out.println("Enter a number to reverse");
        int number = scn.nextInt();
        String reversedNumber = "";

        while (number > 0) {
            reversedNumber += ""+ number % 10;
            number /= 10;
        }
        System.out.println("Your reversed number: " + reversedNumber);
    }

    private static void createAndBubbleSortArray() {
        System.out.println("Enter length of the array");
        int numberArray[] = new int[scn.nextInt()];

        for (int i = 0; i < numberArray.length; i++) {
            System.out.println("Enter a number: ");
            numberArray[i] = scn.nextInt();
        }

        boolean isDoneSorting = false;
        for (int i = 0; i < numberArray.length; i++) {
            isDoneSorting = true;

            for (int j = 0; j < numberArray.length - 1; j++) {
                if(numberArray[j] > numberArray[j+1]) {
                    int numTemp = numberArray[j];
                    numberArray[j] = numberArray[j+1];
                    numberArray[j+1] = numTemp;
                    isDoneSorting = false;
                }
            }

            if(isDoneSorting) {
                break;
            }
        }
        Arrays.stream(numberArray).forEach(number -> System.out.print(number + " "));
    }

    private static void calculateAverageFromListWithStreams(List<Integer> list) {
        int average = (int) (list.stream()
                        .mapToInt(number -> number.intValue())
                        .sum() / list.stream().count());

        System.out.println("The average: " + average);

    }

    private static void convertAllStringsToUpperCaseWithStreams(List<String> list) {
        list.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);
    }

    private static void filterThreeLetterStringsWithStreams(List<String> list) {
        list.stream()
                .filter(s -> s.length() <= 3 && s.startsWith("a"))
                .toList()
                .forEach(System.out::println);
    }

    private static void changeAndDisplayListOfNumbersWithStreams(List<Integer> list) {
        String result = list.stream()
                .map(number -> number%2 == 0 ? "e"+number : "o"+number)
                .collect(Collectors.toList())
                .toString().replaceAll("[\\[\\]]", "");

        System.out.println(result);
    }

    private static void findEmployeeWithStreams() {
        Employee employee = employees.stream()
                .filter(empl -> empl.getSalary() > 30_000)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(employee);
    }

    private static void sortEmployeeList() {
        employees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSurname))
                .collect(Collectors.toList());

        employees.forEach(System.out::println);
    }

    private static void findTopSalary() {
        System.out.println(employees.stream()
                .mapToDouble(employee -> employee.getSalary())
                .max()
                .orElse(0));
    }






}
