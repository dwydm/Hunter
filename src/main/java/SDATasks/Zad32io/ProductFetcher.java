package SDATasks.Zad32io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductFetcher {


    public void saveProductListInFile(List<Product> products) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("products.bin"));


        products.forEach(product -> {
            try {
                writer.write(String.valueOf(product));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
