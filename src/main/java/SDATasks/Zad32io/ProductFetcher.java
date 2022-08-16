package SDATasks.Zad32io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFetcher {
    private final static String FILE_PATH = "src\\main\\java\\SDATasks\\Zad32io\\Products.csv";

    public void saveProductListInFile(List<Product> products) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(products);
            oos.flush();
/*            products.stream().forEach(product -> {
                try {
                    oos.writeObject(product);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });*/
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> readProductListInFile() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            List<Product> products = (List<Product>) ois.readObject();
            ois.close();
            return products;
            //return  (List<Product>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

}
