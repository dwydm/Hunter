package SDAKurs.Dzien8.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurant {
    private final Set<Dish> dishSet = new HashSet<>();


    public void addDish(Dish dish) {
        dishSet.add(dish);
    }

    public void removeDish(Dish dish) {
        if (!dishSet.equals(dish)) {
            return;
        }
        dishSet.remove(dish);
    }

    public Dish findDish(String name) throws RestaurantException {
        boolean dishNotFound = true;
        Dish foundDish = null;

        for (Dish dish : dishSet) {
            if(dish.getName().equals(name)) {
                foundDish =  dish;
                dishNotFound = false;
                break;
            }
        }

        if(dishNotFound) {
            throw new RestaurantException("Dish is not on the list");
        } else {
            return foundDish;
        }
    }

    public List<Dish> findDishesByType(DishType type) {
        List<Dish> dishesList = new ArrayList<>();

        for (Dish dish : dishSet) {
            if (dish.getType() == type) {
                dishesList.add(dish);
            }
        }

        return dishesList;
    }
}
