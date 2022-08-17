package SDATasks.zad33io;

import SDATasks.Zad32io.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private String name;
    private List<Product> productList = new ArrayList<>();
}
