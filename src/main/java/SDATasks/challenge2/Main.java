package SDATasks.challenge2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1=new Product("fasola", 10, 1, Country.POLAND);
        Product product2=new Product("Coca-Cola", 7, 6, Country.USA);
        Product product3=new Product("Banan", 20, 4, Country.CHINA);
        Product product4=new Product("Krem do rąk", 3, 20, Country.JAPAN);
        Product product5=new Product("Długopis", 10, 2.5, Country.POLAND);

        Order order=new Order(new ArrayList<>(List.of(product1, product2, product4, product3)));
        Order order2=new Order(new ArrayList<>(List.of( product2, product4, product3)));
        Order order3=new Order(new ArrayList<>(List.of(product1, product4, product3, product5)));
        Order order4=new Order(new ArrayList<>(List.of(product1,  product4, product3,  product3)));
        Order order5=new Order(new ArrayList<>(List.of(product1, product2, product3, product4, product3)));

        Customer customer=new Customer(new ArrayList<>(List.of(order)), "Jacek", LocalDate.now().minusYears(20));
        Customer customer2=new Customer(new ArrayList<>(List.of(order2, order5, order3)), "Wojtek", LocalDate.now().minusYears(25));
        Customer customer3=new Customer(new ArrayList<>(List.of(order2, order4)), "Krzysiek", LocalDate.now().minusYears(15));
        Customer customer4=new Customer(new ArrayList<>(List.of()), "Kamil", LocalDate.now().minusYears(19));
        Customer customer5=new Customer(new ArrayList<>(List.of(order5)), "Adrian", LocalDate.now().minusYears(40));

        Shop shop=new Shop(new ArrayList<>(List.of(customer, customer2, customer3, customer4, customer5)));

        //shop.displayCustomersNames();

        //shop.displayAverageCustomerAge();

/*        List<Customer> customersWithOrders = shop.getCustomersWithOrders();
        customersWithOrders.forEach(customerWithOrder -> System.out.println(customerWithOrder.getName()));*/

/*        List<Customer> adultCustomers = shop.getSortedAdultCustomers();
        adultCustomers.forEach(adultCustomer -> System.out.println(adultCustomer.getName() + " " + adultCustomer.getAge()));*/

/*        List<Order> weekOldOrders = shop.getUpToWeekOldOrders();
        weekOldOrders.forEach(orderTime -> System.out.println(orderTime.getOrderTime()));*/

        //System.out.println(shop.getAverageNumberOfOrders());

        //System.out.println(shop.getAveragePriceOfAllOrders());

        //System.out.println(shop.getCustomerWithHighestOrder().getName());

        //System.out.println(shop.getProductWithLowestCount());

        //shop.getProductsOrderedOverWeekAgo().stream().forEach(product -> System.out.println(product.getName()));


    }
}
