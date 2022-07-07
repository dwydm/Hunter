package Dzien5.Zad9Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileConnection {


    public List<String> mapFileContent(File file) throws FileConnectionException, FileNotFoundException {
        Random rnd = new Random();
        Scanner scn = new Scanner(file);

        if(rnd.nextDouble() < 0.25) {
            throw new FileConnectionException("Connection failed");
        }

        List<String> fileContent = new ArrayList<>();
        while (scn.hasNext()) {
            fileContent.add(scn.nextLine());
        }
        return fileContent;
    }
}
