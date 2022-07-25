package SDAKurs.Dzien8.Restaurant;

import java.util.HashSet;
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

}
