package SDATasks.recap1.GroceryShop;

import java.time.LocalDate;
import java.util.function.Supplier;

public interface Product {

    double getProductPrice();

    boolean isProductAvailable(LocalDate date);

    int getProductCount();

    void increaseProductCount(int count);

    void decreaseProductCount(int count);



}
