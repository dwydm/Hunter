package SDATasks.zad33io.serializator;

import java.util.List;

public class Serializator <T>{
    private static OrderSaver save = new OrderSaver();
    private static OrderLoader load = new OrderLoader();

    public void saveOrder(List<T> listToSave) {
        save.saveOrder((List<Object>) listToSave);
    }

    public List<T> loadOrder() {
        return (List<T>) load.orderLoader();
    }




}
