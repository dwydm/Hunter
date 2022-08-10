package SDATasks.ChallengeP2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Shop {
    private List<Customer> customers;

    public Shop(List<Customer> customers) {
        this.customers = customers;
    }

    //zwróć imiona customerów posortowane alfabetycznie
    public void displayCustomersNames() {
        customers.stream()
                .map(customer -> customer.getName())
                .sorted()
                .forEach(System.out::println);

    }

    //zwróć średni wiek customerów
    public void displayAverageCustomerAge() {
        System.out.println(customers.stream()
                .mapToInt(customer -> customer.getAge())
                .sum() / customers.stream()
                .count());

    }

    //zwróć customerów którzy mają jakieś zamówienia
    public List<Customer> getCustomersWithOrders() {
        return customers.stream()
                .filter(customer -> !customer.getOrders().isEmpty())
                .collect(Collectors.toList());
    }

    //zwróć tylko pełnoletnich customerów posortowanych po ich wieku
    public List<Customer> getSortedAdultCustomers() {
        return customers.stream()
                .filter(customer -> customer.getAge() >= 18)
                .sorted((customer1, customer2) -> customer1.getAge() - customer2.getAge())
                .collect(Collectors.toList());
    }

    //zwróć zamówienia nie starsze niż tydzień
    public List<Order> getUpToWeekOldOrders() {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusDays(7)))
                .collect(Collectors.toList());
    }

    //zwróć średnią ilość produktów w zamówieniach
    public double getAverageNumberOfOrders() {
        return (double) customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .count() / customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .count();
    }

    //zwróć średnią cenę produktów ze wszystkich zamówień
    public double getAveragePriceOfAllOrders() {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum() / customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .count();
    }

    //zwróć customera, który wydał najwięcej
    public Customer getCustomerWithHighestOrder() {
        return customers.stream()
                .sorted(Comparator.comparingDouble(this::sumUpCustomersOrder).reversed())
                .findFirst()
                .orElse(null);
    }

    private Double sumUpCustomersOrder(Customer customer) { //metoda pomocnicza
        return customer.getOrders().stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .sum();
    }

    //zwróć produkt którego mamy najmniej (wg. amount)
    public Product getProductWithLowestCount() {
        return null;
    }

    //zwróć wszystkie produkty zamówione później niż tydzień temu
    public List<Product> getProductsOrderedOverWeekAgo() {
        return null;
    }

    //trudne:
//zwróć mapę której kluczem będzie numer miesiąca a wartością ilość customerów urodzonych w danym miesiącu
    public Map<Integer, Integer> getTotalCustomerBirdthMonthCount() {
        return null;
    }

    //zwróć mapę zawierającą kraj oraz ilość produktów pochodzących z tego kraju
    public Map<Country, Integer> getProductCountByCountry() {
        return null;
    }
}
