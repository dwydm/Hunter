package SDATasks.zad33io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class OrderLoader {
    private static final String ORDER_FILE = "src\\main\\java\\SDATasks\\zad33io\\orders.bin";


    public List<Order> orderLoader() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            return (List<Order>) ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new ArrayList<>();
    }
}
