package SDATasks.ChallengeP2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private List<Product> products;
    private static Random rnd = new Random();
    private LocalDateTime orderTime;

    public Order(List<Product> products) {
        this.products = products;
        orderTime = LocalDateTime.now().minusDays(rnd.nextInt(15));
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", orderTime=" + orderTime +
                '}';
    }
}

