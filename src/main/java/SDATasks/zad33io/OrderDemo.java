package SDATasks.zad33io;

import SDATasks.Zad32io.Product;

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

        Order order1 = new Order("T1", productList1);
        Order order2 = new Order("T2", productList2);

        OrderSaver os = new OrderSaver();
        OrderLoader ol = new OrderLoader();
        os.saveOrder(new ArrayList<>(Arrays.asList(order1,order2)));

        ol.orderLoader().stream().forEach(System.out::println);

    }
}
