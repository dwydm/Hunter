package SDATasks.zad33io;

import SDATasks.Zad32io.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 109L;
    private String name;
    private List<Product> productList = new ArrayList<>();


    public Order(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }


    @Override
    public String toString() {
        return name + " | " + productList;
    }
}



/*    Przygotuj klasę Order, która będzie zawierać listę produktów oraz imię zamawiającego.
        Przygotuj klasę OrderSaver, która za pomocą metody saveOrders(List<Order>) zapisze do pliku “orders.bin” serializowaną wersję obiektu
        Przygotuj klasę OrderLoader która będzie posiadała analogiczną funkcjonalność wczytującą serializowane obiekty
        dla chętnych: połącz obie implementacje w jeden obiekt Serializator, zdolny zapisywać i odczytywać dowolny obiekt. Zastosuj typy generyczne. */
