package SDATasks.recap1.GroceryShop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static List<Product> productList;
    private List<Product> products;
    static {
        productList = new ArrayList<>(List.of(
                new GenericProduct(()-> 22.22, localDate -> localDate.isBefore(LocalDate.now()), () -> 5),
                new GenericProduct(()-> 1.32, localDate -> localDate.isBefore(LocalDate.now()), () -> 30),
                new GenericProduct(()-> 5.56, localDate -> localDate.isBefore(LocalDate.now()), () -> 22),
                new GenericProduct(()-> 12.31, localDate -> localDate.isBefore(LocalDate.now()), () -> 18),
                new GenericProduct(()-> 7.13, localDate -> localDate.isBefore(LocalDate.now()), () -> 90)
        ));
    }

    public Basket() {
        products = productList;
    }

    public void addNewProduct(double price, LocalDate expirationDate, int units) {
        products.add(new GenericProduct(()-> price, localDate -> localDate.isBefore(expirationDate), () -> units));
    }

    public void displayAvailability() {
        products.forEach(product -> System.out.println(product.isProductAvailable(LocalDate.now())));
    }

    public void checkPrice() {
        products.forEach(product -> System.out.println(product.getProductPrice()));
    }

    public void displayProductCount() {
        products.forEach(product -> System.out.println(product.getProductCount()));
    }

    public void increaseProductCount(int productNumber, int increaseByValue) {
        if(productNumber < 0 || productNumber >= products.size()) {
            return;
        }
        products.get(productNumber).increaseProductCount(increaseByValue);
    }

    public void decreaseProductCount(int productNumber, int decreaseByValue) {
        if(productNumber < 0 || productNumber >= products.size()) {
            return;
        }
        products.get(productNumber).decreaseProductCount(decreaseByValue);
    }

    public List<Product> getBasketContent() {
        return products;
    }



}
