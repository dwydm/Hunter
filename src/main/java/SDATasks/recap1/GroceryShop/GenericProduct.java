package SDATasks.recap1.GroceryShop;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenericProduct implements Product {
    private Supplier<Double> price;
    private Function<LocalDate,Boolean> availability;
    private Supplier<Integer> units;
    public GenericProduct(Supplier<Double> price, Function<LocalDate, Boolean> availability, Supplier<Integer> units) {
        this.price = price;
        this.availability = availability;
        this.units = units;
    }

    @Override
    public double getProductPrice() {
        return price.get();
    }

    @Override
    public boolean isProductAvailable(LocalDate date) {
        return availability.apply(date);
    }

    @Override
    public int getProductCount() {
        return units.get();
    }

    @Override
    public void decreaseProductCount(int count) {
        int oldCount = units.get();
        units = () -> oldCount - count;

    }

    @Override
    public void increaseProductCount(int count) {
        int oldCount = units.get();
        units = () -> oldCount + count;
    }


}
