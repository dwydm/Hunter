package SDATasks.zad33io;

import SDATasks.Zad5.Line;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class OrderSaver {
    private static final String ORDER_FILE = "src\\main\\java\\SDATasks\\zad33io\\orders.bin";

    public void saveOrder(List<Order> orderList) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            oos.writeObject(orderList);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }


}
