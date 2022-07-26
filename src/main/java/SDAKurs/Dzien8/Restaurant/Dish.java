package SDAKurs.Dzien8.Restaurant;

import java.util.Objects;

public class Dish {

    private String name;
    private double price;
    private double calories;
    private DishType type;


    public Dish (String name, double price, double calories, DishType type) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && Double.compare(dish.calories, calories) == 0 && name.equals(dish.name) && type == dish.type;
    }

    public String getName() {
        return name;
    }

    public DishType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, calories, type);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price + ", Calories count: " + calories + ", Type: " + type;
    }
}
