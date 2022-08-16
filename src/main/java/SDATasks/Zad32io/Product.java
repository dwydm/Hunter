package SDATasks.Zad32io;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 108L;
    private String name;
    private double price;
    private int amount;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " | " + amount + " | " + price + " PLN";
    }
}
