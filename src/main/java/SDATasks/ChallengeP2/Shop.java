package SDATasks.ChallengeP2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    }
//zwróć customerów którzy mają jakieś zamówienia
    public List<Customer> getCustomersWithOrders() {
        return null;
    }
//zwróć tylko pełnoletnich customerów posortowanych po ich wieku
    public List<Customer> getSortedAdultCustomers() {
        return null;
    }
//zwróć zamówienia nie starsze niż tydzień
    public List<Order> getUpToWeekOldOrders() {
        return null;
    }
//zwróć średnią ilość produktów w zamówieniach
    public double getAverageNumberOfOrders() {
        return 0.0;
    }
//zwróć średnią cenę produktów ze wszystkich zamówień
    public double getAveragePriceOfAllOrders() {
        return 0.0;
    }
//zwróć customera, który złożył wydał najwięcej
    public Customer getCustomerWithHighestOrder() {
        return null;
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
    public Map<Integer,Integer> getTotalCustomerBirdthMonthCount() {
        return null;
    }
//zwróć mapę zawierającą kraj oraz ilość produktów pochodzących z tego kraju
    public Map<Country,Integer> getProductCountByCountry() {
        return null;
    }
}
