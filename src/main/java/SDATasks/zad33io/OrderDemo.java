package SDATasks.zad33io;

import SDATasks.Zad32io.Product;
import SDATasks.zad33io.serializator.OrderLoader;
import SDATasks.zad33io.serializator.OrderSaver;
import SDATasks.zad33io.serializator.Serializator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Raspberries",10, 1);
        Product p2 = new Product("Bananas",7, 5);
        Product p3 = new Product("Grapes",3, 4);
        Product p4 = new Product("Plums",2, 10);

        List<Product> productList1 = new ArrayList<>(Arrays.asList(p1,p2));
        List<Product> productList2 = new ArrayList<>(Arrays.asList(p3,p4));

        Order order1 = new Order("Bob", productList1);
        Order order2 = new Order("Kate", productList2);
        Serializator<Order> srlz = new Serializator<>();

        srlz.saveOrder(new ArrayList<>(Arrays.asList(order1,order2)));

        List<Order> orderList = srlz.loadOrder();
        orderList.forEach(System.out::println);

    }
}
